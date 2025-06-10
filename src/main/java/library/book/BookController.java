package library.book;

import java.util.List;
import library.reservation.dto.CollectionReservationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    private final BookApiClient bookApiClient;

    public BookController(final BookApiClient bookApiClient) {
        this.bookApiClient = bookApiClient;
    }


    @GetMapping("/search")
    public ResponseEntity<BookResponse> getCollections(@RequestBody String search) {
        bookApiClient.searchBook(search);
        return ResponseEntity.ok( bookApiClient.searchBook(search));
    }
}
