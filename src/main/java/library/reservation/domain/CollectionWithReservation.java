package library.reservation.domain;

import java.time.LocalDate;
import library.collection.Collection;

public record CollectionWithReservation(
        Long collectionId,
        String location,
        Long ReservationId,
        LocalDate dueDate
) {



}
