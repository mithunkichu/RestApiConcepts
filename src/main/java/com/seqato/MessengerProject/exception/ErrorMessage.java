package com.seqato.MessengerProject.exception;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage 

{
	private String errorMessage;
	private int errorCode;
	private String documents;
	
	public ErrorMessage()
	{
		
	}

	public ErrorMessage(String errorMessage, int errorCode, String documents) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documents = documents;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}
	

}
