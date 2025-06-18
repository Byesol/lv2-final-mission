package library.borrow;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import library.collection.Collection;
import library.collection.CollectionRepository;
import library.member.Member;
import library.member.MemberRepository;
import library.reservation.domain.CollectionStatus;
import library.reservation.dto.MemberRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BorrowService {

    private final BorrowRepository borrowRepository;
    private final CollectionRepository collectionRepository;
    private final MemberRepository memberRepository;

    public BorrowService(BorrowRepository borrowRepository, 
                        CollectionRepository collectionRepository,
                        MemberRepository memberRepository) {
        this.borrowRepository = borrowRepository;
        this.collectionRepository = collectionRepository;
        this.memberRepository = memberRepository;
    }

    public BorrowResponse borrowBook(Long collectionId, MemberRequest memberRequest) {
        Collection collection = collectionRepository.findById(collectionId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 도서입니다."));

        if (collection.getCollectionStatus() != CollectionStatus.AVAILABLE) {
            throw new IllegalArgumentException("대출 가능한 도서가 아닙니다.");
        }

        Member member = findMember(memberRequest.email());

        LocalDate dueDate = LocalDate.now().plusDays(14);
        collection.setCollectionStatus(CollectionStatus.BORROWED);

        Borrow borrow = new Borrow(collection,member,dueDate);


        Borrow savedBorrow = borrowRepository.save(borrow);
        return BorrowResponse.from(savedBorrow);
    }


    private Member findMember(String email) {

        Member member = memberRepository.findByEmail(email)
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("email 해당하는 member 없습니다."));
        return member;
    }
} 