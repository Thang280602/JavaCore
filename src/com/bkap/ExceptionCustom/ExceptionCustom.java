package com.bkap.ExceptionCustom;

public class ExceptionCustom extends Exception {
	public ExceptionCustom(String message){
		super(message);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
