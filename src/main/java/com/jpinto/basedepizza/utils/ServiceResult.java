package com.jpinto.basedepizza.utils;

public class ServiceResult<T> {
	
	private		boolean		success;
	private		int 		statusCode;
	private 	String  	message;
	private  	T 			result;
	private  	T 			resultBeforeCheck;

	
	public void setSuccess(boolean success){
		this.success = success;
	}
	public boolean isSuccess() {
		this.result = this.resultBeforeCheck;
		return success;	
	}

	public T getResult(){
		return this.result;
	}
	
	public void setResult(T result){
		this.resultBeforeCheck = result;
	}
	
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	
	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}
	public int getStatusCode(){
		return this.statusCode;
	}
	
	
	
}