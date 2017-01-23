package com.jpinto.basedepizza.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorCode {
	
	private boolean	success;
	private	int 	errorCode;
	private String  message;
	
	
	public ErrorCode(boolean success,int errorCode, String message){
		this.success=success;
		this.errorCode=errorCode;
		this.message=message;
	}
}
