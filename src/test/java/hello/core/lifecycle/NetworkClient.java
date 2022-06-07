package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//javax 패키지는 자바에서 공식적으로 지원하는 기능

public class NetworkClient {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url  = " + url);
    }

    public void  setUrl(String url){
        this.url = url;
    }

    //서비스 시작시 호출
    public void  connect(){
        System.out.println("connect: = " + url);
    }

    public void  call(String massage){
        System.out.println("call: " + url + "massage = " + massage);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close = " + url);
    }


    //의존관계 주입이 끝나면 호출
    @PostConstruct
    public void init() throws Exception {
        connect();
        call("초기화 연결 메세지");
    }

    //빈이 종료될 떄 호출
    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }
}
