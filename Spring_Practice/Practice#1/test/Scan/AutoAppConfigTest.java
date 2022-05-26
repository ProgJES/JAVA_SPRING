package Hello.core.Scan;

import Hello.core.AutoAppConfig;
import Hello.core.Order.Order;
import Hello.core.Order.OrderService;
import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean("memberServiceImpl",MemberService.class);
        OrderService orderService = ac.getBean(OrderService.class);
    
        Member member = new Member(1L, "JORDY", Grade.VIP);
        memberService.JoinMember(member);
        Member findMember = memberService.FindMember(1L);
        
        Order order = orderService.createOrder(1L, "Shampoo", 10000);

        System.out.println("order = " + order);

        System.out.println("member = " + findMember);
        assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
