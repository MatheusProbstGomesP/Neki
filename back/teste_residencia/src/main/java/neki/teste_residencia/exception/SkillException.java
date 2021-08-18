package neki.teste_residencia.exception;

public class SkillException extends Exception{

    private static final long serialVersionUID = 1L;

    public SkillException() {
        super();
    }

    public SkillException(String message) {
        super(message);
    }

    public SkillException(String message, Exception cause) {
        super(message, cause);
    }

    public SkillException(Exception e) {
        super(e);
    }

}
