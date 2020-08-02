package id.akademi.amani.courses.controllers.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignatureResponse
{
    private String  apiKey;
    private String  signature;
    private Integer role;
    private String  passcode;
}
