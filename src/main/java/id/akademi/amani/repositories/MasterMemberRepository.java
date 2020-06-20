package id.akademi.amani.repositories;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import id.akademi.amani.repositories.entities.MasterMember;

@Repository
public interface MasterMemberRepository extends BaseRepository<MasterMember, String>
{
    Optional<MasterMember> findByEmailAndPassword(String email, String password);
}
