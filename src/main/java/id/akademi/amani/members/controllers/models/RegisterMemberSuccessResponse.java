package id.akademi.amani.members.controllers.models;

import java.time.LocalDate;
import id.akademi.amani.commons.MemberType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RegisterMemberSuccessResponse extends RegisterMemberAbstractResponse
{
    private String     uuid;
    private String     email;
    private String     lastName;
    private String     password;
    private String     firstName;
    private LocalDate  dateOfBirth;
    private MemberType memberType = MemberType.REGULER;
}
