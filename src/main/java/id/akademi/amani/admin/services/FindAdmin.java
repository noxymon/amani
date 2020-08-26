package id.akademi.amani.admin.services;

import id.akademi.amani.admin.mappers.EntityMapper;
import id.akademi.amani.admin.services.models.SystemUserOutput;
import id.akademi.amani.repositories.SystemUserRepository;
import id.akademi.amani.repositories.entities.SystemUserEntity;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import id.akademi.amani.admin.services.models.AuthUserParameter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAdmin
{
    private final SystemUserRepository systemUserRepository;
    private final EntityMapper entityMapper = EntityMapper.INSTANCE;

    public SystemUserOutput byParam(AuthUserParameter authUserParameter)
    {
        SystemUserEntity exampleSystemUser = new SystemUserEntity();
        exampleSystemUser.setEmail(authUserParameter.getEmail());
        exampleSystemUser.setPassword(authUserParameter.getPassword());
        Example<SystemUserEntity> systemUserEntityExample = Example.of(exampleSystemUser);

        final SystemUserEntity existingSystemUserEntity = systemUserRepository
          .findOne(systemUserEntityExample)
          .orElseThrow();
        return entityMapper.from(existingSystemUserEntity);
    };
}
