package id.akademi.amani.members.controllers.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterMemberFailedResponse extends RegisterMemberAbstractResponse
{
    private final String reason;
}
