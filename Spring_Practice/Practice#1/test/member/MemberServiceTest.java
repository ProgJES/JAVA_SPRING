package Hello.core.member;

import Hello.core.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class MemberServiceTest {
    MemberService memberService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join(){
        //given
            Member member = new Member(1L, "Jordy", Grade.VIP);

        //when
            memberService.JoinMember(member);
            Member findMember = memberService.FindMember(1L);
        //then
        Assertions.assertEquals(member, findMember);
    }
}
