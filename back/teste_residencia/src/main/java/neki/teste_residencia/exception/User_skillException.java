package neki.teste_residencia.exception;

public class User_skillException extends Exception{

    private static final long serialVersionUID = 1L;

    public User_skillException() {
        super();
    }

    public User_skillException(String message) {
        super(message);
    }

    public User_skillException(String message, Exception cause) {
        super(message, cause);
    }

    public User_skillException(Exception e) {
        super(e);
    }

}
