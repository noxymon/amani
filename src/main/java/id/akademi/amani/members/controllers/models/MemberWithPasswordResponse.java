package id.akademi.amani.members.controllers.models;

import id.akademi.amani.repositories.entities.MasterMember;
import lombok.Getter;

@Getter
public class MemberWithPasswordResponse extends MemberResponse
{
    private String password;

    public MemberWithPasswordResponse(String id, String email, String firstName,
                                      String lastName, String memberType, String password)
    {
        super(id, email, firstName, lastName, memberType);
        this.password = password;
    }

    public static MemberResponse from(MasterMember masterMember)
    {
        return new MemberWithPasswordResponse(
                masterMember.getId(),
                masterMember.getEmail(),
                masterMember.getFirstName(),
                masterMember.getLastName(),
                masterMember.getMemberType(),
                masterMember.getPassword()
        );
    }
}
