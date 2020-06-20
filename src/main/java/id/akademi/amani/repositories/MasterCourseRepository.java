package id.akademi.amani.repositories;

import id.akademi.amani.repositories.entities.MasterCourse;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MasterCourseRepository extends BaseRepository<MasterCourse, String>
{
}
