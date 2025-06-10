package library.reservation.service;

import library.reservation.domain.Reservation;

public record ReservationResponse(
        Long id,
        String email,
        Long collectionId

) {

    public static ReservationResponse from(final Reservation newReservation) {
        return new ReservationResponse(newReservation.getId(), newReservation.getMember().getEmail(),
                newReservation.getCollection().getId());
    }
}
