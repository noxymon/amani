package id.akademi.amani.users.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.akademi.amani.users.controllers.models.AuthLoginRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserAuthController
{
    
    @PostMapping("/auth")
    public void authLogin(@RequestBody AuthLoginRequest authLoginRequest)
    {
    };
}