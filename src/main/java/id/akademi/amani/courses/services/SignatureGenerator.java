package id.akademi.amani.courses.services;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import id.akademi.amani.courses.services.models.MeetingDetailResponse;
import id.akademi.amani.courses.services.models.SignatureOutput;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignatureGenerator {

	@Value("${apps.webinar.apikey}") 
	private String apiKey;
	@Value("${apps.webinar.apiSecret}") 
	private String apiSecret;
	@Value("${apps.webinar.api-url}") 
	private String apiUrl;

	private final RestTemplate restTemplate;
	private static final int PARTICIPANT_ROLE_ID = 1;
	
    public SignatureOutput generateParticipantSignature(String meetingNumber){
        try {
			ResponseEntity<MeetingDetailResponse> meetingDetailResponseEntity = getMeetingDetailFromApi(meetingNumber);
			return composeBasicSignatureOutput(meetingNumber, meetingDetailResponseEntity.getBody().getPassword());
	  	} catch (NoSuchAlgorithmException | InvalidKeyException e) {
              throw new RuntimeException(e);
        }
	}

	private ResponseEntity<MeetingDetailResponse> getMeetingDetailFromApi(String meetingNumber) {
		HttpEntity<MeetingDetailResponse> httpEntity = composeHttpEntity();
		ResponseEntity<MeetingDetailResponse> meetingDetailResponseEntity = 
					restTemplate.exchange(
						apiUrl + "/meetings/" + meetingNumber, 
						HttpMethod.GET, httpEntity, 
						MeetingDetailResponse.class
					);
		return meetingDetailResponseEntity;
	}

	private HttpEntity<MeetingDetailResponse> composeHttpEntity() {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.setBearerAuth(generateJwtToken());			
		return new HttpEntity<MeetingDetailResponse>(header);
	}

	private SignatureOutput composeBasicSignatureOutput(String meetingNumber, String passcode)
			throws NoSuchAlgorithmException, InvalidKeyException {
		Mac hasher = Mac.getInstance("HmacSHA256");
		String ts = Long.toString(System.currentTimeMillis() - 30000);
		String msg = String.format("%s%s%s%d", apiKey, meetingNumber, ts, PARTICIPANT_ROLE_ID);
		
		hasher.init(new SecretKeySpec(apiSecret.getBytes(), "HmacSHA256"));
		
		String message = Base64.getEncoder().encodeToString(msg.getBytes());
		byte[] hash = hasher.doFinal(message.getBytes());
		
		String hashBase64Str = DatatypeConverter.printBase64Binary(hash);
		String tmpString = String.format("%s.%s.%s.%d.%s", apiKey, meetingNumber, ts, PARTICIPANT_ROLE_ID, hashBase64Str);
		String encodedString = Base64.getEncoder().encodeToString(tmpString.getBytes());

		return SignatureOutput.builder()
							  .apiKey(apiKey)
							  .signature(encodedString.replaceAll("\\=+$", ""))
							  .passcode(passcode)
							  .build();
	};

	private String generateJwtToken(){
		LocalDateTime jwtExpiredDate = LocalDateTime.now().plusHours(1);
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		Date jwtExpiredFromLocalDate = Date.from(jwtExpiredDate.atZone(ZoneId.systemDefault()).toInstant());

		Map<String, Object> headerMap = new HashMap<>();
		headerMap.put("alg", signatureAlgorithm.getValue());
		headerMap.put(Header.TYPE, Header.JWT_TYPE);

		SecretKey key = Keys.hmacShaKeyFor(apiSecret.getBytes(StandardCharsets.UTF_8));

		return Jwts.builder()
				.setHeader(headerMap)
				.setIssuer(apiKey)
				.setExpiration(jwtExpiredFromLocalDate)
				.signWith(key, signatureAlgorithm)
				.compact();
	};
}