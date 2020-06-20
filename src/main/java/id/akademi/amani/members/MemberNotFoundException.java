package id.akademi.amani.members;

public class MemberNotFoundException extends RuntimeException
{
    public MemberNotFoundException(String message)
    {
        super(message);
    }

    public MemberNotFoundException()
    {
        super("Member Not Found !");
    }
}
