package practice2.Practice2.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import practice2.Practice2.domain.Member;
import practice2.Practice2.repository.MemberRepository;
import practice2.Practice2.repository.MemoryMemberRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("USER-B");

        //when
        Long saveID = memberService.join(member);
        //then
        //Member findMember = memberService.findOne(saveID).get();
        //assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateMember() {
        //given
        Member member1 = new Member();
        Member member2 = new Member();

        member1.setName("User-A");
        member2.setName("User-A");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("Existing member");


    }
}
