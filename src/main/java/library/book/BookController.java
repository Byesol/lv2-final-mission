package library.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookApiClient bookApiClient;

    public BookController(BookApiClient bookApiClient) {
        this.bookApiClient = bookApiClient;
    }

    @GetMapping("/books/search")
    public ResponseEntity<BookResponse> searchBooks(@RequestParam("query") String query) {
        BookResponse response = bookApiClient.searchBook(query);
        return ResponseEntity.ok(response);
    }
}
