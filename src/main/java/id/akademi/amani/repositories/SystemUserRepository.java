package id.akademi.amani.repositories;

import id.akademi.amani.repositories.entities.SystemUser;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SystemUserRepository extends BaseRepository<SystemUser, UUID>
{
}
