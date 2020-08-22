package id.akademi.amani.repositories;

import java.util.Optional;
import org.springframework.stereotype.Repository;
import id.akademi.amani.repositories.entities.MasterMemberEntity;

@Repository
public interface MasterMemberRepository extends BaseRepository<MasterMemberEntity, String>
{
    Optional<MasterMemberEntity> findByEmailAndPassword(String email, String password);
}
