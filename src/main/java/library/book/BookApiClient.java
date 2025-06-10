package library.book;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClient;



@Component
public class BookApiClient {

    private static final String SECRET_KEY_SUFFIX = ":";
    private static final String AUTHORIZATION_HEADER = "Basic ";
    public static final String BOOK_URL = "https://openapi.naver.com/v1/search/book.json";

    private final RestClient restClient;

    public BookApiClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public BookResponse searchBook(final String  search) {

        try {
            return restClient.post()
                    .uri(uriBuilder -> uriBuilder.path("BOOK_URL")
                            .queryParam("query", "%EC%A3%BC%EC%8B%9D")
                            .build())
                    .contentType(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .toEntity(BookResponse.class)
                    .getBody();
        } catch (HttpClientErrorException e) {

            throw new IllegalArgumentException(e.getMessage());
        } catch (HttpServerErrorException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}
