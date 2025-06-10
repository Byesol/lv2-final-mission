package library.reservation.service;

import java.util.List;
import library.collection.Collection;
import library.collection.CollectionRepository;
import library.reservation.domain.CollectionStatus;
import library.reservation.domain.CollectionWithReservation;
import library.reservation.dto.CollectionReservationResponse;
import library.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final CollectionRepository collectionRepository;

    public ReservationService(final CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<CollectionReservationResponse> getCollections(Long bookId) {
        // 내가 선택한 책 id를 가지는 collection들의 정보를 예약 정보와 함께 불러온다.
        List<Collection> collections = collectionRepository.findByBookId(bookId);
        return collections.stream()
                .map(CollectionReservationResponse::from)
                .toList();
//        List<Collection> collections = collectionRepository.findByBookId(bookId);
//        for (Collection collection : collections) {
//            if (collection.getCollectionStatus().equals(CollectionStatus.RESERVED)){
//
//            }
//        }
//        List<CollectionWithReservation> collectionWithReservations = collectionRepository.findCollectionWithReservationByBookId(
//                bookId);
//        collectionWithReservations.stream()
//                .map(collectionWithReservation -> )
//


//                2. 각각의 컬렉션이 이제 예약들을 가진다? 근데 null 일 수도 있자나
//                3. 책을 빌린 상태면 저걸 검색하자ㅏㅏ..
    }
}
