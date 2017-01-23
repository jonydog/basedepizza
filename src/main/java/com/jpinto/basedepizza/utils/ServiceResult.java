package com.jpinto.basedepizza.utils;

public class ServiceResult<T> {
	
	private  ErrorCode errorCode;
	private  T result;
	private  T resultBeforeCheck;

	public boolean isSuccess() {
		this.result = this.resultBeforeCheck;
		return this.errorCode.isSuccess();
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
	
	public T getResult(){
		return this.result;
	}
	
	public void setResult(T result){
		this.resultBeforeCheck = result;
	}
	
	public void setErrorCode(ErrorCode errorCode){
		this.errorCode = errorCode;
	}
}