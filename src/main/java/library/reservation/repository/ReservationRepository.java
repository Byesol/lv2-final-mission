package library.reservation.repository;

import library.reservation.domain.Reservation;

public interface ReservationRepository {
    Reservation save(Reservation reservation);
}
