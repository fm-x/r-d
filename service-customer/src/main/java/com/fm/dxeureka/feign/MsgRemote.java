package com.fm.dxeureka.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fm.dxeureka.feign.callback.MsgRemoteHystrix;

@FeignClient(name = "fm-service-producer", fallback = MsgRemoteHystrix.class)
public interface MsgRemote {

	String TAG_MSG_SERVICE = "/msg";

	@RequestMapping(TAG_MSG_SERVICE + "/notice")
	public String rcNotice(@RequestParam("obj") String obj);

}
