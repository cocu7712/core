package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름 조회")
    void findBeanByName(){
        MemberService ms = ac.getBean("memberService",MemberService.class);
//        System.out.println("ms = " + ms);
//        System.out.println("ms.getClass() = " + ms.getClass());

        assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }

  @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService ms = ac.getBean(MemberService.class);
        assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        MemberService ms = ac.getBean("memberService",MemberServiceImpl.class);
        assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
        
        //오른쪽 메서드가 실행해서 NoSuchBeanDefinitionException 에러가 터져야 성공
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx",MemberService.class));
    }

}
