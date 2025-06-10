package library.reservation.service;

import java.util.List;
import library.collection.Collection;
import library.collection.CollectionRepository;
import library.member.Member;
import library.member.MemberRepository;
import library.reservation.dto.MemberRequest;
import library.reservation.domain.CollectionStatus;
import library.reservation.domain.Reservation;
import library.reservation.dto.CollectionReservationResponse;
import library.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final CollectionRepository collectionRepository;
    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;

    public ReservationService(final CollectionRepository collectionRepository,
                              final ReservationRepository reservationRepository,
                              final MemberRepository memberRepository) {
        this.collectionRepository = collectionRepository;
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
    }

    public List<CollectionReservationResponse> getCollections(Long bookId) {
        // 내가 선택한 책 id를 가지는 collection들의 정보를 예약 정보와 함께 불러온다.
        List<Collection> collections = collectionRepository.findByBookId(bookId);
        return collections.stream()
                .map(CollectionReservationResponse::from)
                .toList();

    }

    public ReservationResponse reserveBook(final Long collectionId, final MemberRequest memberRequest) {
        String email = memberRequest.email();
        Collection collection = collectionRepository.findById(collectionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 소장 자료 없습니다."));
        if (!collection.getCollectionStatus().equals(CollectionStatus.BORROWED)) {
            throw new IllegalArgumentException("현재 예약 불가능합니다.");
        }
        System.out.println("email = " + email);
        Member member = memberRepository.findByEmail(email)
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("email 해당하는 member 없습니다."));

        Reservation reservation = new Reservation(collection, member);
        Reservation newReservation = reservationRepository.save(reservation);
        return ReservationResponse.from(newReservation);


    }
}
