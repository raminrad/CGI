package gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest;

import gov.gsa._18f.hackathon.fall2015.datacenter.application.ApplicationException;

/**
 * @author dfladung
 *
 */
public class RestApiError {

	public RestApiError() {

	}

	public RestApiError(int status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public RestApiError(ApplicationException ex) {
		status = 500;
		code = ex.getErrorCode().toString();
		message = ex.getMessage();
	}

	int status;

	String code;

	String message;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
