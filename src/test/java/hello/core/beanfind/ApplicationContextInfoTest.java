package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String s : beanDefinitionNames ){
            Object bean = ac.getBean(s);
            System.out.println("bean = " + s + " object = " + bean);
        }

    }

    @Test
    @DisplayName("애플리케이션션 빈 력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String s : beanDefinitionNames ){
            BeanDefinition beanDefinition = ac.getBeanDefinition(s);

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(s);
                System.out.println("bean = " + s + " object = " + bean);
            }
        }

    }

}
