package exception;

public class DatabaseServiceException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public DatabaseServiceException(String message) {
		super(message);
	}
}
