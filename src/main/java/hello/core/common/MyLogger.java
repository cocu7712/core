package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)   // 해당 빈은 HTTP요청 당 하나씩 생성되고, HTTP 요청이 끝나느 시점에 소멸된다.
// proxyMode = ScopedProxyMode.TARGET_CLASS 는 가짜 프록시 객체를 주입하고 가짜 프록시 객체는 요청이 오면 그때 내부에서 진짜 빈을 요청하는 위임 로직이 들어있다.
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL (String requestURL){
        this.requestURL = requestURL;
    }

    public void log(String message){
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct  // 의존성 주입이 이루어진 후 초기화를 수행하는 메서드이다. Ex) service 로직을 타기 전에 발생
    public void init()  {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "]" + " request scope bean create: " + this);
    }

    @PreDestroy // 스프링 컨테이너에서 객체(빈)를 제[거하기 전에 해야할 작업이 있다면 메소드위에 사용하는 어노테이션.
    public void close(){
        System.out.println("[" + uuid + "]" + " request scope bean close: " + this);
    }
}
