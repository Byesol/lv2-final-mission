package library.book;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClient;



@Component
public class BookApiClient {


    public static final String BOOK_URL = "https://openapi.naver.com/v1/search/book.json";

    private final RestClient restClient;

    public BookApiClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public BookResponse searchBook(final String  search) {

        try {
            String encodedQuery = URLEncoder.encode(search, StandardCharsets.UTF_8);
            String url = BOOK_URL + "?query=" + encodedQuery;

            return restClient.get() //
                    .uri(URI.create(url)) //
                    .retrieve()
                    .toEntity(BookResponse.class)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException("Book search failed", e);
        }
    }

}
