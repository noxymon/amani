package id.akademi.amani.couses.services;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@SpringBootTest
@ActiveProfiles("local")
@RunWith(SpringRunner.class)
public class SignatureGeneratorTest {

    @Test
    public void geerateToken(){
        System.out.println("JWT :::::::::::::::::::::: " + generateJwtToken());
    };

    public String generateJwtToken(){
		LocalDate jwtExpiredDate = LocalDate.now().plusDays(1);
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		Date jwtExpiredFromLocalDate = Date.from(jwtExpiredDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

		Map<String, Object> headerMap = new HashMap<>();
		headerMap.put("alg", signatureAlgorithm.getValue());
		headerMap.put(Header.TYPE, Header.JWT_TYPE);

		SecretKey key = Keys.hmacShaKeyFor("Qg6o0pYxZd0A30SP9EkVPa7Z4Ortczrl0AVj".getBytes(StandardCharsets.UTF_8));

	    	//replace issuer with apikey of zoom
		return Jwts.builder()
				.setHeader(headerMap)
				.setIssuer("fillWithApiKeyHere")
				.setExpiration(jwtExpiredFromLocalDate)
				.signWith(key, signatureAlgorithm)
				.compact();
	};
}
