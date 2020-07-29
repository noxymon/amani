package id.akademi.amani.courses.controllers.models;

import lombok.Getter;

@Getter
public class FailedSignatureResponse extends SignatureResponse {
    public FailedSignatureResponse(String errorMessage) {
        super(null, null, -1, null);
        this.errorMessage = errorMessage;
    }
    private final String errorMessage;
}