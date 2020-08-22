package id.akademi.amani.members;

public class MemberNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public MemberNotFoundException(String message)
    {
        super(message);
    }

    public MemberNotFoundException()
    {
        super("Member Not Found !");
    }
}
