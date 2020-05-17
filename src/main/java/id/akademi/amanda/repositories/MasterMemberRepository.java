package id.akademi.amanda.repositories;

import id.akademi.amanda.repositories.entities.MasterMember;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterMemberRepository extends BaseRepository<MasterMember, String>
{
}
