package library.reservation.repository;

import java.util.List;
import library.reservation.domain.Reservation;

public interface ReservationRepository {
    Reservation save(Reservation reservation);

    List<Reservation> findByMemberId(Long id);
}
