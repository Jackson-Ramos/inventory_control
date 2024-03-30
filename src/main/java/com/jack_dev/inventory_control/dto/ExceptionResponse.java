package com.jack_dev.inventory_control.dto;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
	
	private Date timestam;
	private String message;
	private String details;
	
	public ExceptionResponse() {
	}
	
	public ExceptionResponse(Date timestam, String message, String details) {
		this.timestam = timestam;
		this.message = message;
		this.details = details;
	}
	
	public Date getTimestam() {
		return timestam;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getDetails() {
		return details;
	}
}
