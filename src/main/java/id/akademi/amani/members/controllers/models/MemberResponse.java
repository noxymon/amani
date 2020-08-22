package id.akademi.amani.members.controllers.models;

import id.akademi.amani.repositories.entities.MasterMemberEntity;
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

    public static MemberResponse from(MasterMemberEntity masterMemberEntity)
    {
        return new MemberResponse(
            masterMemberEntity
              .getId().toString(),
            masterMemberEntity.getEmail(),
            masterMemberEntity.getFirstName(),
            masterMemberEntity.getLastName(),
            masterMemberEntity.getMemberType()
        );
    };
}
