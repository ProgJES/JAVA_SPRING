package Hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Override
    public void JoinMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member FindMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
