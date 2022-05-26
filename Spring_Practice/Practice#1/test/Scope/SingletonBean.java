package Hello.core.Scope;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonBean {
    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBeanTest.class);
        SingletonBeanTest singletonBeanTest1 = ac.getBean(SingletonBeanTest.class);
        SingletonBeanTest singletonBeanTest2 = ac.getBean(SingletonBeanTest.class);
        System.out.println("singletonBeanTest1 = " + singletonBeanTest1);
        System.out.println("singletonBeanTest2 = " + singletonBeanTest2);
        assertThat(singletonBeanTest1).isSameAs(singletonBeanTest2);
        ac.close();
    }
    @Scope("singleton")
    @RequiredArgsConstructor
    static class SingletonBeanTest {

        @PostConstruct
        public void init() {
            System.out.println("Singleton initialized");
        }
        @PreDestroy
        public void close() {
            System.out.println("Singleton Destroyed");
        }
    }
}
