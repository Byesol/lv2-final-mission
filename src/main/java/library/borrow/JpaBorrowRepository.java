package library.borrow;

import java.util.List;
import library.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBorrowRepository extends BorrowRepository, JpaRepository<Borrow, Long> {
    List<Borrow> findByMember(Member member);
} 