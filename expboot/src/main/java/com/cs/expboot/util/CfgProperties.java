package com.cs.expboot.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CfgProperties {

	@Value("${com.cs.code}")
	private String code;
	@Value("${com.cs.msg}")
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "CfgProperties [code=" + code + ", msg=" + msg + "]";
	}

}
