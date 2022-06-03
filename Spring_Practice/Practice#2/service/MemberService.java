package practice2.Practice2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice2.Practice2.domain.Member;
import practice2.Practice2.repository.MemberRepository;
import practice2.Practice2.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {

            validateMember(member);

            memberRepository.save(member);
            return member.getID();


    }
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long ID) {
        return memberRepository.findByID(ID);
    }
    private void validateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m-> {
            throw new IllegalStateException("Existing member");
        });
    }

}
