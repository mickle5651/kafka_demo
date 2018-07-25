package com.hisign.kafka_demo.vo;

import lombok.Getter;

@Getter
public enum ResultCode{


	SUCCESS("0"),
	EXCEPTION("-1");

	private String code;

	ResultCode(String code){
		this.code = code;
	}





}
