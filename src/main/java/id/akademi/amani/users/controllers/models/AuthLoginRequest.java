package id.akademi.amani.users.controllers.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AuthLoginRequest {
    private final String email;
    private final String password;
}
