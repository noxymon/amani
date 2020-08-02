package id.akademi.amani.members.controllers.models;

import id.akademi.amani.repositories.entities.MasterMember;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberResponse
{
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String memberType;

    public static MemberResponse from(MasterMember masterMember)
    {
        return new MemberResponse(
            masterMember.getId().toString(),
            masterMember.getEmail(),
            masterMember.getFirstName(),
            masterMember.getLastName(),
            masterMember.getMemberType()
        );
    };
}
