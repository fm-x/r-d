package com.fm.dxeureka.route;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.fm.dxeureka.common.AppConstants;

@Component
public class MSGFallbackProvider implements FallbackProvider {
	private final Logger LOGGER = LoggerFactory.getLogger(MSGFallbackProvider.class);

	@Autowired
	private AppConstants appConstants;

	@Override
	public String getRoute() {
		return appConstants.serviceIdMsg;
	}

	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return 200;
			}

			@Override
			public String getStatusText() throws IOException {
				return "OK";
			}

			@Override
			public void close() {
				LOGGER.info("ClientHttpResponse close...");
			}

			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream(("The service of " + appConstants.serviceIdMsg + "is unavailable.").getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
		};
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		if (cause != null && cause.getCause() != null) {
			String reason = cause.getCause().getMessage();
			LOGGER.info("{}->Excption {}", route, reason);
		}
		return fallbackResponse();
	}

}
