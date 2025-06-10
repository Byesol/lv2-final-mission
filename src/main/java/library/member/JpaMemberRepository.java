package library.member;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends MemberRepository, JpaRepository<Member,Long> {
    List<Member> findByEmail(String email);
}
