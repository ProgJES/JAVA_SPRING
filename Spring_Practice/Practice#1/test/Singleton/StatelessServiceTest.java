package Hello.core.Singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StatelessServiceTest {

    @Test
    void StatelessServiceTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatelessService statelessService1 = ac.getBean("statelessService", StatelessService.class);
        StatelessService statelessService2 = ac.getBean("statelessService", StatelessService.class);

        int User_A = statelessService1.order("User-A", 10000);
        int User_B = statelessService1.order("User-B", 20000);

        assertThat(User_A).isEqualTo(10000);
    }
    static class TestConfig {
        @Bean
        public  StatelessService statelessService() {
            return new StatelessService();
        }
    }
}
