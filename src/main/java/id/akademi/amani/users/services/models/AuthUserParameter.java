package id.akademi.amani.users.services.models;

import lombok.Builder;
import lombok.Getter;

/**
 * AuthUserParameter
 */
@Getter
@Builder
public class AuthUserParameter {
    private final String email;
    private final String password;
}