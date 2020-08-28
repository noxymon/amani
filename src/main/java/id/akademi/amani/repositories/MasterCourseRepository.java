package id.akademi.amani.repositories;

import org.springframework.stereotype.Repository;
import id.akademi.amani.repositories.entities.MasterCourseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface MasterCourseRepository extends BaseRepository<MasterCourseEntity, UUID>
{
    Stream<MasterCourseEntity> findAllByPublishedEqualsAndPublicAccessEquals(boolean published, boolean publicAccess);
}
