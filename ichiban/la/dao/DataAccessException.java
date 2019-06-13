package la.dao;

public class DataAccessException extends Exception {

	public DataAccessException() {
		super();
	}

	public DataAccessException(String msg) {
		super(msg);
	}

	public DataAccessException(Throwable cause) {
		super(cause);
	}

	public DataAccessException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
