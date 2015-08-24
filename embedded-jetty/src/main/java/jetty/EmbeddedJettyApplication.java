package jetty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Ufuk on 24-08-15.
 */
@SpringBootApplication
public class EmbeddedJettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmbeddedJettyApplication.class, args);
    }
}
