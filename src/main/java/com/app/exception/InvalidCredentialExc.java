package com.app.exception;

@SuppressWarnings("serial")
public class InvalidCredentialExc extends RuntimeException {
public InvalidCredentialExc(String msg) {
	super(msg);
}
}
