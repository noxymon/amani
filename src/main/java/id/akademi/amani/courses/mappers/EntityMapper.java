package id.akademi.amani.courses.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import id.akademi.amani.courses.services.models.MasterCourse;
import id.akademi.amani.repositories.entities.MasterCourseEntity;

@Mapper(componentModel = "spring")
public interface EntityMapper
{
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    MasterCourse from(MasterCourseEntity masterCourseEntity);
    List<MasterCourse> from(List<MasterCourseEntity> masterCourseEntity);
}
