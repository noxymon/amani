package id.akademi.amani.members.controllers.models;

import id.akademi.amani.repositories.entities.MasterMemberEntity;
import lombok.Getter;

@Getter
public class MemberWithPasswordResponse extends MemberResponse
{
    private String password;

    public MemberWithPasswordResponse(String id, String email, String firstName, String lastName,
        String memberType, String password)
    {
        super(id, email, firstName, lastName, memberType);
        this.password = password;
    }

    public static MemberResponse from(MasterMemberEntity masterMemberEntity)
    {
        return new MemberWithPasswordResponse(
            masterMemberEntity
              .getId().toString(),
            masterMemberEntity.getEmail(),
            masterMemberEntity.getFirstName(),
            masterMemberEntity.getLastName(),
            masterMemberEntity.getMemberType(),
            masterMemberEntity.getPassword()
        );
    }
}
