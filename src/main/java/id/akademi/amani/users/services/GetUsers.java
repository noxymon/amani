package id.akademi.amani.users.services;

import id.akademi.amani.repositories.SystemUserRepository;
import id.akademi.amani.repositories.entities.SystemUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetUsers
{
    private final SystemUserRepository systemUserRepository;

    public List<SystemUser> fetchAll()
    {
        return systemUserRepository.findAll();
    }
}
