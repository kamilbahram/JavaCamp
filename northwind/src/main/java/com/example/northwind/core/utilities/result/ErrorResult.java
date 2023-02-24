package com.example.northwind.core.utilities.result;

public class ErrorResult extends Result {

	public ErrorResult() {
		super(false);
		// TODO Auto-generated constructor stub
	}
	public ErrorResult(String message) {
		super(false,message);
	}

}
