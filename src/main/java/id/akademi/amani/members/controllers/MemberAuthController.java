package id.akademi.amani.members.controllers;

import javax.security.sasl.AuthenticationException;

import id.akademi.amani.members.MemberAuthenticationFailedException;
import id.akademi.amani.members.controllers.models.MemberWithPasswordResponse;
import id.akademi.amani.members.services.GetMemberDetail;
import id.akademi.amani.members.MemberNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.akademi.amani.members.controllers.models.AuthMemberRequest;
import id.akademi.amani.members.controllers.models.MemberResponse;
import id.akademi.amani.members.services.MemberAutheticator;
import id.akademi.amani.members.services.models.AuthMemberParameter;
import id.akademi.amani.repositories.entities.MasterMemberEntity;
import lombok.RequiredArgsConstructor;

/**
 * MemberAuthController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/member")
public class MemberAuthController
{

    private final GetMemberDetail    getMemberDetail;
    private final MemberAutheticator memberAutheticator;

    @PostMapping("/auth")
    public ResponseEntity authMemberLogin(@RequestBody AuthMemberRequest authMemberRequest)
    {
        AuthMemberParameter authMemberParameter = AuthMemberParameter.from(authMemberRequest);

        try {
            MasterMemberEntity authenticatedMember = memberAutheticator.authMember(authMemberParameter);

            return new ResponseEntity<MemberResponse>(
                    MemberResponse.from(authenticatedMember),
                    HttpStatus.OK
            );
        } catch (AuthenticationException e) {
            return failedResponseEntity();
        }
    }

    private ResponseEntity failedResponseEntity()
    {
        return new ResponseEntity<MemberAuthenticationFailedException>(
                unkownUsernamePasswordMemberAuthException(),
                HttpStatus.UNAUTHORIZED
        );
    }

    private MemberAuthenticationFailedException unkownUsernamePasswordMemberAuthException()
    {
        return new MemberAuthenticationFailedException("Username or Password not known");
    }

    @GetMapping("/details/{email}")
    public ResponseEntity getUsernameDetails(@PathVariable String email)
    {
        try {
            final MasterMemberEntity memberFound = getMemberDetail.getDetail(email);
            return new ResponseEntity<MemberResponse>(
                    MemberWithPasswordResponse.from(memberFound),
                    HttpStatus.OK
            );
        } catch (MemberNotFoundException ex) {
            return new ResponseEntity<MemberNotFoundException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
}
