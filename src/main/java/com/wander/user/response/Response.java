package com.wander.user.response;

import org.springframework.http.HttpStatus;

public class Response<T> extends ResponseModel {

	T result;

	HttpStatus statusCode;

	public Response() {
	}

	public Response(T a) {
		result = a;

	}

	public Response(T a, HttpStatus status) {
		result = a;
		this.statusCode = status;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
