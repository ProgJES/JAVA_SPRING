package Hello.core;

import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MemberApp {
    public static void main(String[] args) {
        //Methods that is declared under @Bean, and in the AppConfig class will be stored and managed applicationContext container
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //applicationContext.getBean("Name of Method", ReturnType.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "Jordy", Grade.VIP);
        memberService.JoinMember(member);

        Member findMember = memberService.FindMember(1L);

        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());
    }
}
