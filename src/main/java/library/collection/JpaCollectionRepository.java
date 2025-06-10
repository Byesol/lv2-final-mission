package library.collection;

import java.util.List;
import library.reservation.domain.CollectionWithReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaCollectionRepository extends CollectionRepository, JpaRepository<Collection,Long> {

//    @Query("SELECT c FROM Collection c " +
//            "LEFT JOIN FETCH c.reservations " +
//            "WHERE c.book.id = :bookId")
//    List<Collection> findCollectionWithReservationByBookId(@Param("bookId") Long bookId);

//    @Query("""
//                SELECT new library.reservation.domain.CollectionWithReservation(
//                    c.id, c.location,
//                    b.id, b.dueDate
//
//                )
//                FROM Collection c
//                LEFT JOIN Reservation r ON r.collection = c
//                LEFT JOIN Borrow b ON b.collection = c
//                WHERE c.book.id = :bookId
//            """)
//    List<CollectionWithReservation> findCollectionsWithReservationByBookId(@Param("bookId") Long bookId);

//    @Query("""
//    SELECT new com.example.dto.CollectionWithStatusResponse(
//        c.id, c.location,
//        r.id, r.dueDate,
//        l.id, l.dueDate
//    )
//    FROM Collection c
//    LEFT JOIN Reservation r ON r.collection = c
//    LEFT JOIN Loan l ON l.collection = c
//    WHERE c.book.id = :bookId
//""")
//    List<CollectionWithStatusResponse> findByBookIdWithReservationAndLoan(@Param("bookId") Long bookId);

}
