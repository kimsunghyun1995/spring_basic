package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] bean = ac.getBeanDefinitionNames();
        for (String b : bean) {
            Object be = ac.getBean(b);
            System.out.println("name = "+b + " Object = " + be);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] bean = ac.getBeanDefinitionNames();
        for (String b : bean) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(b);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object be = ac.getBean(b);
                System.out.println("name = "+b + " Object = " + be);
            }
        }
    }



}
