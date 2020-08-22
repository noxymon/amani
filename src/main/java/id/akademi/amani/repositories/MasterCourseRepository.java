package id.akademi.amani.repositories;

import org.springframework.stereotype.Repository;
import id.akademi.amani.repositories.entities.MasterCourseEntity;

@Repository
public interface MasterCourseRepository extends BaseRepository<MasterCourseEntity, String>
{
}
