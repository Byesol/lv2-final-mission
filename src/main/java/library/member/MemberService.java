package library.member;

import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(String email) {
        Member member = new Member(email);
        return memberRepository.save(member);
    }
} 