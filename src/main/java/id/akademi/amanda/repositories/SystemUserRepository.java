package id.akademi.amanda.repositories;

import id.akademi.amanda.repositories.entities.SystemUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends BaseRepository<SystemUser, String>
{
}
