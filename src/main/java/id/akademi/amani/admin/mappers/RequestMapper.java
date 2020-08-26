package id.akademi.amani.admin.mappers;

import id.akademi.amani.admin.controllers.models.AuthLoginRequest;
import id.akademi.amani.admin.services.models.AuthUserParameter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RequestMapper
{
    RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

    AuthUserParameter from(AuthLoginRequest authLoginRequest);
}
