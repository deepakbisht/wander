package com.wander.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wander.user.response.ErrorObject;
import com.wander.user.response.ErrorResponse;
import com.wander.user.response.ResponseModel;

import javassist.NotFoundException;

@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public ResponseModel illegalRequest(HttpServletRequest request, HttpServletResponse response,
			IllegalArgumentException e) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return new ErrorResponse<ErrorObject>(
				new ErrorObject(String.valueOf(HttpServletResponse.SC_BAD_REQUEST), e.getMessage()));
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	public ResponseModel messageNotReadableException(HttpServletRequest request, HttpServletResponse response,
			HttpMessageNotReadableException e) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return new ErrorResponse<ErrorObject>(
				new ErrorObject(String.valueOf(HttpServletResponse.SC_BAD_REQUEST), e.getMessage()));

	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseBody
	public ResponseModel missingRequestParam(HttpServletRequest request, HttpServletResponse response,
			HttpMessageNotReadableException e) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return new ErrorResponse<ErrorObject>(
				new ErrorObject(String.valueOf(HttpServletResponse.SC_BAD_REQUEST), e.getMessage()));

	}
	

	@ExceptionHandler(TypeMismatchException.class)
	@ResponseBody
	public ResponseModel handleTypeMismatchException(HttpServletResponse response, HttpServletRequest request,
			TypeMismatchException e) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

		return new ErrorResponse<ErrorObject>(
				new ErrorObject(String.valueOf(HttpServletResponse.SC_BAD_REQUEST), e.getMessage()));

	}

	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public ResponseModel handleNullPointerException(HttpServletResponse response, HttpServletRequest request,
			TypeMismatchException e) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

		return new ErrorResponse<ErrorObject>(
				new ErrorObject(String.valueOf(HttpServletResponse.SC_BAD_REQUEST), e.getMessage()));

	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	public ResponseModel handleResourceNotFound(HttpServletResponse response, HttpServletRequest request,
			TypeMismatchException e) {
		response.setStatus(HttpServletResponse.SC_NOT_FOUND);

		return new ErrorResponse<ErrorObject>(
				new ErrorObject(String.valueOf(HttpServletResponse.SC_NOT_FOUND), e.getMessage()));

	}
	

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseModel unknownException(HttpServletRequest request, HttpServletResponse response, Exception e)
			throws Exception {
		e.printStackTrace();
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return new ErrorResponse<ErrorObject>(
				new ErrorObject(String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR),
						"Something Bad,really bad happened:" + e.getMessage()));
	}

}
