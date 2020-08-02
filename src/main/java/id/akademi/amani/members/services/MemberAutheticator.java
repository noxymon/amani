package id.akademi.amani.members.services;

import java.util.Optional;
import javax.security.sasl.AuthenticationException;

import id.akademi.amani.members.MemberAuthenticationFailedException;
import org.springframework.stereotype.Service;
import id.akademi.amani.members.services.models.AuthMemberParameter;
import id.akademi.amani.repositories.MasterMemberRepository;
import id.akademi.amani.repositories.entities.MasterMember;
import lombok.RequiredArgsConstructor;

/**
 * MemberAutheticator
 */
@Service
@RequiredArgsConstructor
public class MemberAutheticator
{

    private final MasterMemberRepository masterMemberRepository;

    public MasterMember authMember(AuthMemberParameter authMemberParameter)
        throws AuthenticationException
    {
        Optional<MasterMember> existingMember = masterMemberRepository.findByEmailAndPassword(
            authMemberParameter.getEmail(),
            authMemberParameter.getPassword()
        );

        assertMemberIsExist(existingMember);
        return existingMember.get();
    }

    private void assertMemberIsExist(Optional<MasterMember> existingMember)
        throws AuthenticationException
    {
        if (!existingMember.isPresent()) {
            throw new MemberAuthenticationFailedException("Username and password not match!");
        }
    };
}
