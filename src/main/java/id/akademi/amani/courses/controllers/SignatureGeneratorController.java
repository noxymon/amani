package id.akademi.amani.courses.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.akademi.amani.courses.controllers.models.FailedSignatureResponse;
import id.akademi.amani.courses.controllers.models.SignatureResponse;
import id.akademi.amani.courses.services.SignatureGenerator;
import id.akademi.amani.courses.services.models.SignatureOutput;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/course")
public class SignatureGeneratorController
{

    private final SignatureGenerator signatureGenerator;

    @GetMapping(value = "/signature/{meetingNumber}")
    public ResponseEntity<SignatureResponse> generateSignature(
        @PathVariable("meetingNumber") String meetingNumber)
    {
        try {
            SignatureOutput generatedSignature =
                signatureGenerator.generateParticipantSignature(meetingNumber);
            SignatureResponse signatureResponse = composeSuccessResponse(generatedSignature);
            return new ResponseEntity<SignatureResponse>(signatureResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<SignatureResponse>(
                new FailedSignatureResponse(e.getMessage()),
                HttpStatus.BAD_REQUEST
            );
        }
    }

    private SignatureResponse composeSuccessResponse(SignatureOutput generatedSignature)
    {
        return SignatureResponse.builder()
            .role(generatedSignature.getRole())
            .apiKey(generatedSignature.getApiKey())
            .passcode(generatedSignature.getPasscode())
            .signature(generatedSignature.getSignature())
            .build();
    }
}
