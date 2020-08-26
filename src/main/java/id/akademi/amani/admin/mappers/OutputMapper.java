package id.akademi.amani.admin.mappers;

import id.akademi.amani.admin.controllers.models.AdminResponse;
import id.akademi.amani.admin.services.models.SystemUserOutput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OutputMapper
{
    OutputMapper INSTANCE = Mappers.getMapper(OutputMapper.class);

    AdminResponse from(SystemUserOutput systemUserOutput);
}
