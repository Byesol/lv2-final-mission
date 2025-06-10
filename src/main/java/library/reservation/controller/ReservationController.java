package library.reservation.controller;


import java.util.List;
import library.reservation.dto.CollectionReservationResponse;
import library.reservation.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CollectionReservationResponse>> getCollections(@PathVariable Long id) {

        List<CollectionReservationResponse> collections = reservationService.getCollections(id);
        return ResponseEntity.ok(collections);

    }
}
