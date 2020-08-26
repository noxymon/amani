package id.akademi.amani.courses.mappers;

import id.akademi.amani.courses.controllers.models.RegisterCourseRequest;
import id.akademi.amani.courses.controllers.models.UpdateCourseRequest;
import id.akademi.amani.courses.services.models.RegisterCourseParam;
import id.akademi.amani.courses.services.models.UpdateCourseParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RequestMapper
{
    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

    UpdateCourseParam from(UpdateCourseRequest updateCourseRequest);
    RegisterCourseParam from(RegisterCourseRequest registerCourseRequest);
}
