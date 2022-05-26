package Hello.core.LifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("Constructor called, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //Call when the service starts
    public void connect() {
        System.out.println("connect:  " + url);
    }
    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //call when the service ends
    public void disconnect() {
        System.out.println("close = " + url);
    }
    //Calls after DI

    @PostConstruct
    public void init() {
        connect();
        call("Initialize connect message");
    }
    @PreDestroy
    public void close()  {
        disconnect();
    }

}
