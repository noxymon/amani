package id.akademi.amani.configs;

import java.time.Duration;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig 
{
    
    @Bean
    public RestTemplate restTempalateConfig(){
        return new RestTemplateBuilder()
                    .setReadTimeout(Duration.ofSeconds(3))
                    .setConnectTimeout(Duration.ofSeconds(5))
                    .requestFactory(()->createCloseableClientHttpRequestFactory())
                    .build();
    };

    private ClientHttpRequestFactory createCloseableClientHttpRequestFactory() {
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        return new HttpComponentsClientHttpRequestFactory(closeableHttpClient);
    }
}