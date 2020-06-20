package id.akademi.amani.members.controllers.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * AuthMemberRequest
 */
@Getter
@RequiredArgsConstructor
public class AuthMemberRequest {
    private final String email;
    private final String password;
}