package com.csi.jfh.yj.test;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class WSTester {

	// webservice url
	private static final String URL = "http://127.0.0.1:8080/jfbid/services/SEL_PLF_PubInfo?wsdl";

	// 命名空间
	private static final String NAMESPACE = "http://impl.service.webService.webservice.portal.jf.csi.com";

	// 请求的方法名
	private static final String METHOD = "proPubInfo";

	// 请求参数名
	private static final String[] PARAMETER = new String[] { "StartTime", "EndTime", "DataCount", "DataSets" };

	private static final String USERNAME = "chinaSoft";// 服务验证的用户名
	private static final String PASSWORD = "chinasoft";// 服务验证的密码

	/**
	 * Header设置验证信息
	 * 
	 * @param serviceClient
	 * @param namespace
	 * @param user
	 * @param passwrod
	 */
	public static void setAuthentication(ServiceClient serviceClient, String namespace, String user, String passwrod) {
		OMFactory factory = OMAbstractFactory.getOMFactory();
		OMNamespace omNamespace = factory.createOMNamespace(namespace, "nsl");
		OMElement header = factory.createOMElement("AuthenticationToken", omNamespace);
		OMElement usernameNode = factory.createOMElement("userName", omNamespace);
		OMElement passwordNode = factory.createOMElement("password", omNamespace);

		usernameNode.setText(user);
		passwordNode.setText(passwrod);

		header.addChild(usernameNode);
		header.addChild(passwordNode);

		serviceClient.addHeader(header);
	}

	/**
	 * RPC请求WS
	 * 
	 * @param values
	 */
	public static void doRPCServiceClientRequest(Object[] values) {
		RPCServiceClient rpcServiceClient;
		try {
			rpcServiceClient = new RPCServiceClient();
			setAuthentication(rpcServiceClient, NAMESPACE, USERNAME, PASSWORD);

			Options options = rpcServiceClient.getOptions();

			EndpointReference targetEPR = new EndpointReference(URL);
			options.setTo(targetEPR);

			Class<?>[] classes = new Class[] { String.class };

			QName opAddEntry = new QName(NAMESPACE, METHOD);
			System.out.println(rpcServiceClient.invokeBlocking(opAddEntry, values, classes)[0]);
		} catch (AxisFault e) {
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * document请求WS
	 * 
	 * @param values
	 */
	public static void doAxis2ServiceClientRequest(Object[] values) {
		try {
			ServiceClient serviceClient = new ServiceClient();
			setAuthentication(serviceClient, NAMESPACE, USERNAME, PASSWORD);

			EndpointReference endpointReference = new EndpointReference(URL);
			Options options = new Options();

			options.setTo(endpointReference);
			serviceClient.setOptions(options);
			OMFactory factory = OMAbstractFactory.getOMFactory();
			// 命名空间
			OMNamespace omNs = factory.createOMNamespace(NAMESPACE, "svc");
			OMElement data = factory.createOMElement(METHOD, omNs);

			for (int i = 0; i < PARAMETER.length; i++) {
				QName qname = new QName(PARAMETER[i]);
				OMElement argNode = factory.createOMElement(qname);
				argNode.setText(values[i] != null ? values[i].toString() : "");
				data.addChild(argNode);
			}

			OMElement result = serviceClient.sendReceive(data);
			System.out.println(result.getFirstElement().getText());
		} catch (AxisFault ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
 
		String[] values = new String[] { "2018-04-28", "2018-04-29", "1", "{\"id\":12}" };

		// 参数
		 doRPCServiceClientRequest(values);
		// doAxis2ServiceClientRequest(values);


	}

	/**
	 * axis-1.x调用 
	 * @throws Exception
	 */
	public static void doAxis1() throws Exception {
		String endpoint = "http://221.226.86.30/njjyservice/Main.asmx?wsdl";
		// 直接引用远程的wsdl文件
		// 以下都是套路
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress(endpoint);
		call.setOperationName("GetGGCount");// WSDL里面描述的接口名称
		call.addParameter("FBDate", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);// 接口的参数
		call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
		String param = "2018-05-09";
		String result = (String) call.invoke(new Object[] { param });
		// 给方法传递参数，并且调用方法
		System.out.println(result);
	}

}
