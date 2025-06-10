package library.member;

import java.util.List;

public interface MemberRepository {
    List<Member> findByEmail(String email);
}
