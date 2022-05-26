package Hello.core.beanFind;

import Hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("Print registered application bean")
    void findApplicationBean() {
        String [] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            //Meta data about bean
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //getRole = Role_Application not pre-registered role
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("Bean Name = " + beanDefinitionName + " Object = " + bean);
            }

        }
    }
}
