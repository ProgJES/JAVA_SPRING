package Hello.core.member;

public interface MemberService {
    void JoinMember(Member member);
    Member FindMember(Long memberId);
}
