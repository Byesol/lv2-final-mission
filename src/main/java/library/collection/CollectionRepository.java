package library.collection;

import java.util.List;
import java.util.Optional;
import library.reservation.domain.CollectionWithReservation;

public interface CollectionRepository {
//    List<CollectionWithReservation> findCollectionWithReservationByBookId(Long id);

    List<Collection> findByBookId(Long bookId);

    Optional<Collection> findById(Long id);
}
