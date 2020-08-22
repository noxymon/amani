package id.akademi.amani.members.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.akademi.amani.commons.MemberType;
import id.akademi.amani.members.controllers.models.RegisterMemberAbstractResponse;
import id.akademi.amani.members.controllers.models.RegisterMemberFailedResponse;
import id.akademi.amani.members.controllers.models.RegisterMemberRequest;
import id.akademi.amani.members.controllers.models.RegisterMemberSuccessResponse;
import id.akademi.amani.members.services.RegisterMember;
import id.akademi.amani.members.services.models.RegisterMemberParam;
import id.akademi.amani.repositories.entities.MasterMemberEntity;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/member")
public class MemberRegisterController
{
    private final RegisterMember registerMember;

    @PostMapping
    public ResponseEntity<RegisterMemberAbstractResponse> register(
        @RequestBody RegisterMemberRequest registerMemberRequest)
    {
        try {
            RegisterMemberParam registerMemberParam = buildRegisterMemberParam(registerMemberRequest);
            final MasterMemberEntity registeredMember = registerMember.registerMember(registerMemberParam);
            return successResponse(registeredMember);
        } catch (RuntimeException e) {
            return failedRegiterResponse(e);
        }
    }

    private ResponseEntity<RegisterMemberAbstractResponse> successResponse(
        final MasterMemberEntity registeredMember)
    {
        return new ResponseEntity<>(buildSuccessResponse(registeredMember), HttpStatus.ACCEPTED);
    }

    private ResponseEntity<RegisterMemberAbstractResponse> failedRegiterResponse(RuntimeException e)
    {
        return new ResponseEntity<>(
            new RegisterMemberFailedResponse(e.getMessage()),
            HttpStatus.BAD_REQUEST
        );
    }

    private RegisterMemberSuccessResponse buildSuccessResponse(final MasterMemberEntity registeredMember)
    {
        return RegisterMemberSuccessResponse.builder()
            .uuid(registeredMember.getId().toString())
            .dateOfBirth(registeredMember.getDateOfBirth().toLocalDate())
            .email(registeredMember.getEmail())
            .firstName(registeredMember.getFirstName())
            .lastName(registeredMember.getLastName())
            .memberType(MemberType.from(registeredMember.getMemberType()))
            .build();
    }

    private RegisterMemberParam buildRegisterMemberParam(RegisterMemberRequest registerMemberRequest)
    {
        return RegisterMemberParam.builder()
            .email(registerMemberRequest.getEmail())
            .lastName(registerMemberRequest.getLastName())
            .password(registerMemberRequest.getPassword())
            .firstName(registerMemberRequest.getFirstName())
            .dateOfBirth(registerMemberRequest.getDateOfBirth())
            .memberType(MemberType.from(registerMemberRequest.getMemberType()))
            .build();
    }
}
