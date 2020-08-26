package id.akademi.amani.admin.services;

import id.akademi.amani.repositories.SystemUserRepository;
import id.akademi.amani.repositories.entities.SystemUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAdmin
{
    private final SystemUserRepository systemUserRepository;

    public List<SystemUserEntity> fetchAll()
    {
        return systemUserRepository.findAll();
    }
}
