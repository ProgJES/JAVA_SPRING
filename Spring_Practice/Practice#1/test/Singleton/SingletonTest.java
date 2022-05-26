package Hello.core.Singleton;

import Hello.core.AppConfig;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("DI container without spring configuration")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //Access#1
        MemberService memberService1 = appConfig.memberService();
        //Access#2
        MemberService memberService2 = appConfig.memberService();

        //Check that each object points different address
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("Use singleton object")
    void singletonServiceTest() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        instance1.logic();
        instance2.logic();
        //Same == check ref same
        //Equal == check value same
        assertThat(instance1).isSameAs(instance2);
    }

    @Test
    @DisplayName("Singleton container with spring framwork")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //Access#1
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        //Access#2
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //Check that each object points different address
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);


        assertThat(memberService1).isSameAs(memberService2);

    }
}
