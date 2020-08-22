package id.akademi.amani.members.services;

import java.util.Optional;
import javax.security.sasl.AuthenticationException;

import id.akademi.amani.members.MemberAuthenticationFailedException;
import org.springframework.stereotype.Service;
import id.akademi.amani.members.services.models.AuthMemberParameter;
import id.akademi.amani.repositories.MasterMemberRepository;
import id.akademi.amani.repositories.entities.MasterMemberEntity;
import lombok.RequiredArgsConstructor;

/**
 * MemberAutheticator
 */
@Service
@RequiredArgsConstructor
public class MemberAutheticator
{

    private final MasterMemberRepository masterMemberRepository;

    public MasterMemberEntity authMember(AuthMemberParameter authMemberParameter)
        throws AuthenticationException
    {
        Optional<MasterMemberEntity> existingMember = masterMemberRepository.findByEmailAndPassword(
            authMemberParameter.getEmail(),
            authMemberParameter.getPassword()
        );

        assertMemberIsExist(existingMember);
        return existingMember.get();
    }

    private void assertMemberIsExist(Optional<MasterMemberEntity> existingMember)
        throws AuthenticationException
    {
        if (!existingMember.isPresent()) {
            throw new MemberAuthenticationFailedException("Username and password not match!");
        }
    };
}
