package id.akademi.amani.members.controllers.models;

import java.time.LocalDate;
import id.akademi.amani.commons.MemberType;
import lombok.Getter;

@Getter
public class RegisterMemberRequest
{
    private String    email;
    private String    password;
    private String    firstName;
    private String    lastName;
    private LocalDate dateOfBirth;
    private String    memberType = MemberType.REGULER.getMemberTypeId();
}
