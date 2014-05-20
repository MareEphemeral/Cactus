package org.cactus.util;

public class ErrorCode {
	private int codeNumber;
	private String happendedPlace;
	private String record;
	private String ErrorMessage;
	
	public ErrorCode()
	{
		codeNumber=0;
		happendedPlace=null;
		record=null;
		ErrorMessage="All Right";
	}
	
	public ErrorCode(int codeNumber, String happendedPlace, String record,
			String errorMessage) {
		super();
		this.codeNumber = codeNumber;
		this.happendedPlace = happendedPlace;
		this.record = record;
		ErrorMessage = errorMessage;
	}

	public int getCodeNumber() {
		return codeNumber;
	}

	public void setCodeNumber(int codeNumber) {
		this.codeNumber = codeNumber;
	}

	public String getHappendedPlace() {
		return happendedPlace;
	}

	public void setHappendedPlace(String happendedPlace) {
		this.happendedPlace = happendedPlace;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	
	
}
