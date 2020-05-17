package id.akademi.amanda.services.repositories;

import id.akademi.amanda.services.repositories.entities.SystemUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends BaseRepository<SystemUser, String>
{
}
