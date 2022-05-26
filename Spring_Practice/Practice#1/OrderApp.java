package Hello.core;

import Hello.core.Order.Order;
import Hello.core.Order.OrderService;
import Hello.core.Order.OrderServiceImpl;
import Hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "Jordy", Grade.VIP);
        memberService.JoinMember(member);

        Order order = orderService.createOrder(memberId, "Shampoo", 10000);

        System.out.println("order= " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
