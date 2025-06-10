package library.reservation.controller;


import java.util.List;
import library.reservation.dto.CollectionReservationResponse;
import library.reservation.dto.MemberRequest;
import library.reservation.service.ReservationResponse;
import library.reservation.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<List<CollectionReservationResponse>> getCollections(@PathVariable Long id) {

        List<CollectionReservationResponse> collections = reservationService.getCollections(id);
        return ResponseEntity.ok(collections);
    }

    @PostMapping("/collection/{id}")
    public ResponseEntity<ReservationResponse> reserveBook(@PathVariable Long id, @RequestBody MemberRequest memberRequest) {

        return ResponseEntity.ok(reservationService.reserveBook(id,memberRequest));
    }

    @GetMapping("/reservation/me")
    public ResponseEntity<List<ReservationResponse>> myReservationAndBorrows(@RequestBody MemberRequest memberRequest) {

        List<ReservationResponse> collections = reservationService.myReservationAndBorrows(memberRequest);
        return ResponseEntity.ok(collections);
    }
}
