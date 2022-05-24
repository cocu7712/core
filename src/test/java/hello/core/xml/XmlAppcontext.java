package hello.core.xml;

import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppcontext {

    @Test
    void xmlAppcontext(){
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService service = ac.getBean("memberService",MemberService.class);
        assertThat(service).isInstanceOf(MemberService.class);

    }
}
