package id.akademi.amani.members.services;

import id.akademi.amani.members.MemberNotFoundException;
import id.akademi.amani.repositories.MasterMemberRepository;
import id.akademi.amani.repositories.entities.MasterMemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMemberDetail
{
    private final MasterMemberRepository masterMemberRepository;

    public MasterMemberEntity getDetail(String email)
    {
        return masterMemberRepository.findById(email)
                                     .orElseThrow(MemberNotFoundException::new);
    }
}
