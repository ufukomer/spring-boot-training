package jetty.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Ufuk on 24-08-15.
 */
@Component
public class HelloWorldService {

    // Spring boot uses the value 'World' if property
    // user doesn't exist in application.property file
    @Value("${user:World}")
    private String user;

    public String getHelloMessage() {
        return "Hello " + this.user + "!";
    }
}
