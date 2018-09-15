package com.wander.user.response;

public class ErrorResponse<T> extends ResponseModel {

	T error;

	public ErrorResponse() {
	}

	public ErrorResponse(T a) {
		error = a;

	}

	public T getError() {
		return error;
	}

	public void setError(T error) {
		this.error = error;
	}

}
