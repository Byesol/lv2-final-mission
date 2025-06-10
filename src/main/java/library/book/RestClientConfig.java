package library.book;

import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient bookkRestClient(
            RestClient.Builder builder
      ) {

       return builder
                .baseUrl("https://api.tosspayments.com/v1")
                .defaultHeader("X-Naver-Client-Id",
                        "KsCtXhM1Feo7P0K24Oka" )
                .defaultHeader("X-Naver-Client-Secret",
                        "e7m7DCN1vn" )

                .build();
    }
}

