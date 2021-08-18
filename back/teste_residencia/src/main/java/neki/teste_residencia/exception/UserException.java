package neki.teste_residencia.exception;

public class UserException extends Exception{
    private static final long serialVersionUID = 1L;

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Exception cause) {
        super(message, cause);
    }

    public UserException(Exception e) {
        super(e);
    }

}
