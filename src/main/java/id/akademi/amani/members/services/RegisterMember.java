package id.akademi.amani.members.services;

import java.sql.Date;
import org.springframework.stereotype.Service;
import id.akademi.amani.members.services.models.RegisterMemberParam;
import id.akademi.amani.repositories.MasterMemberRepository;
import id.akademi.amani.repositories.entities.MasterMemberEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterMember
{
    private final MasterMemberRepository masterMemberRepository;
    
    public MasterMemberEntity registerMember(RegisterMemberParam addMemberParam)
    {
        MasterMemberEntity masterMemberEntity = new MasterMemberEntity();
        masterMemberEntity.setEmail(addMemberParam.getEmail());
        masterMemberEntity.setActive(true);
        masterMemberEntity.setDateOfBirth(Date.valueOf(addMemberParam.getDateOfBirth()));
        masterMemberEntity.setFirstName(addMemberParam.getFirstName());
        masterMemberEntity.setLastName(addMemberParam.getLastName());
        masterMemberEntity.setMemberType(addMemberParam.getMemberType().getMemberTypeId());
        masterMemberEntity.setPassword(addMemberParam.getPassword());
        
        return masterMemberRepository.save(masterMemberEntity);
    }
}
