package gov.gsa._18f.hackathon.fall2015.datacenter.application;

/**
 * @author dfladung
 *
 */
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ApplicationErrorCode errorCode;

	public ApplicationException() {
		errorCode = ApplicationErrorCode.E_Unknown;
	}

	public ApplicationException(ApplicationErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ApplicationException(ApplicationErrorCode errorCode, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return String.format("ApplicationException [errorCode=%s, getMessage()=%s]", errorCode, getMessage());
	}

	public ApplicationErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ApplicationErrorCode errorCode) {
		this.errorCode = errorCode;
	}

}
