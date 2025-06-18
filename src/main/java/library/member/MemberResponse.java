package library.member;

public record MemberResponse(Long id, String email) {
    
    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getId(), member.getEmail());
    }
} 