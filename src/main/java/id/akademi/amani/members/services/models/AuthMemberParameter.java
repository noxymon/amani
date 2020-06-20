package id.akademi.amani.members.services.models;

import id.akademi.amani.members.controllers.models.AuthMemberRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthMemberParameter {
    private final String email;
    private final String password;

    public static AuthMemberParameter from(AuthMemberRequest authMemberRequest){
        return AuthMemberParameter.builder()
                                .email(authMemberRequest.getEmail())
                                .password(authMemberRequest.getPassword())
                                .build();
    };
}
