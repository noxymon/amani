package id.akademi.amani.admin.controllers;

import id.akademi.amani.admin.mappers.OutputMapper;
import id.akademi.amani.admin.mappers.RequestMapper;
import id.akademi.amani.admin.services.FindAdmin;
import id.akademi.amani.admin.services.models.SystemUserOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.akademi.amani.admin.controllers.models.AuthLoginRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class AdminAuthController
{
    private final FindAdmin     findAdmin;
    private final OutputMapper  outputMapper  = OutputMapper.INSTANCE;
    private final RequestMapper requestMapper = RequestMapper.INSTANCE;

    @PostMapping("/auth")
    public ResponseEntity<?> authLogin(@RequestBody AuthLoginRequest authLoginRequest)
    {
        final SystemUserOutput systemUserOutput = findAdmin.byParam(requestMapper.from(authLoginRequest));
        return new ResponseEntity<>(outputMapper.from(systemUserOutput), HttpStatus.OK);
    }

    ;
}
