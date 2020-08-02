package id.akademi.amani.members.services.models;

import java.time.LocalDate;
import id.akademi.amani.commons.MemberType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RegisterMemberParam
{
    private String email;
    private String lastName;
    private String password;
    private String firstName;
    private LocalDate dateOfBirth;
    @Builder.Default
    private MemberType memberType = MemberType.REGULER;
}
