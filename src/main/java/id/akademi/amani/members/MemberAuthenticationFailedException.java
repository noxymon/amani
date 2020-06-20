package id.akademi.amani.members;

/**
 * AuthentictionFailedException
 */
public class MemberAuthenticationFailedException extends RuntimeException{
    
    private static final long serialVersionUID = 3056572900757077314L;

    public MemberAuthenticationFailedException(String message) {
        super(message);
    }
}