package id.akademi.amani.users.services;

import org.springframework.stereotype.Service;
import id.akademi.amani.repositories.SystemUserRepository;
import id.akademi.amani.users.services.models.AuthUserParameter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAuthenticator 
{
    private final SystemUserRepository systemUserRepository;

    public void authUser(AuthUserParameter authUserParameter)
    {
            
    };
}