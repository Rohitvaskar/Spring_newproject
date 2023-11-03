package com.HMS.exception;

import java.util.Date;

public class ErrorDetails {

	private Date timestand;
	private String message;
	private String details;

	public Date getTimestand() {
		return timestand;
	}

	public void setTimestand(Date timestand) {
		this.timestand = timestand;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public ErrorDetails(Date timestand, String message, String details) {
		super();
		this.timestand = timestand;
		this.message = message;
		this.details = details;
	}

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
