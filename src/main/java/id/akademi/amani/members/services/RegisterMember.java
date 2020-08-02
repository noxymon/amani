package id.akademi.amani.members.services;

import java.sql.Date;
import org.springframework.stereotype.Service;
import id.akademi.amani.members.services.models.RegisterMemberParam;
import id.akademi.amani.repositories.MasterMemberRepository;
import id.akademi.amani.repositories.entities.MasterMember;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterMember
{
    private final MasterMemberRepository masterMemberRepository;
    
    public MasterMember registerMember(RegisterMemberParam addMemberParam)
    {
        MasterMember masterMember = new MasterMember();
        masterMember.setEmail(addMemberParam.getEmail());
        masterMember.setActive(true);
        masterMember.setDateOfBirth(Date.valueOf(addMemberParam.getDateOfBirth()));
        masterMember.setFirstName(addMemberParam.getFirstName());
        masterMember.setLastName(addMemberParam.getLastName());
        masterMember.setMemberType(addMemberParam.getMemberType().getMemberTypeId());
        masterMember.setPassword(addMemberParam.getPassword());
        
        return masterMemberRepository.save(masterMember);
    }
}
