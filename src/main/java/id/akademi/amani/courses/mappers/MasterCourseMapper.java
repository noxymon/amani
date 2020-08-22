package id.akademi.amani.courses.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import id.akademi.amani.courses.services.models.MasterCourse;
import id.akademi.amani.repositories.entities.MasterCourseEntity;

@Mapper(componentModel = "spring")
public interface MasterCourseMapper {
    MasterCourseMapper INSTANCE = Mappers.getMapper(MasterCourseMapper.class);

    MasterCourse map(MasterCourseEntity masterCourseEntity);

    List<MasterCourse> map(List<MasterCourseEntity> masterCourseEntity);
}