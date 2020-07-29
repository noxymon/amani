package id.akademi.amani.courses.services.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignatureOutput {
    private String apiKey;
    private String signature;
    @Builder.Default
    private Integer role = 1;
    private String passcode;
}