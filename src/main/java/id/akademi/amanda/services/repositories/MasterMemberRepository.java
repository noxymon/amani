package id.akademi.amanda.services.repositories;

import id.akademi.amanda.services.repositories.entities.MasterMember;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterMemberRepository extends BaseRepository<MasterMember, String>
{
}
