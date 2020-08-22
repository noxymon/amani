package id.akademi.amani.courses;

public class CourseException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public CourseException(String message)
    {
        super(message);
    }
}
