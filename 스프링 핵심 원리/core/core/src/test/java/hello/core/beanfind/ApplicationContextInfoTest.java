package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beadnDefinitionNames = ac.getBeanDefinitionNames();
        // iter + tab
        for (String beadnDefinitionName : beadnDefinitionNames) {
            Object bean = ac.getBean(beadnDefinitionName);
            // soutv + tab
            System.out.println("name = " + beadnDefinitionName + ", object = " + bean);
        }
    }

    @Test
    @DisplayName("모든 빈 출력하기")
    void findApplicationBean() {
        String[] beadnDefinitionNames = ac.getBeanDefinitionNames();
        // iter + tab
        for (String beadnDefinitionName : beadnDefinitionNames) {
            BeanDefinition beadDefinition = ac.getBeanDefinition(beadnDefinitionName);

            if (beadDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = ac.getBean(beadnDefinitionName);
                System.out.println("name = " + beadnDefinitionName + ", object = " + bean);
            }
        }
    }
}
