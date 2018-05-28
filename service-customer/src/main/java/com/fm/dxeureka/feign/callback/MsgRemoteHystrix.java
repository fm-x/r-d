package com.fm.dxeureka.feign.callback;

import org.springframework.stereotype.Component;

import com.fm.dxeureka.feign.MsgRemote;

@Component
public class MsgRemoteHystrix implements MsgRemote {

	@Override
	public String rcNotice(String obj) {
		return "(Fm-service-producer) service exception, unable to provide services to " + obj;
	}

}
