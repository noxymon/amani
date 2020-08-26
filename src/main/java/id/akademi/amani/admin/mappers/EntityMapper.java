package id.akademi.amani.admin.mappers;

import id.akademi.amani.admin.services.models.SystemUserOutput;
import id.akademi.amani.repositories.entities.SystemUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EntityMapper
{
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    SystemUserOutput from(SystemUserEntity systemUserEntity);
}
