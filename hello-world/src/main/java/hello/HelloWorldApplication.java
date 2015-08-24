package hello;

import hello.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Ufuk on 24-08-15.
 */
@SpringBootApplication
public class HelloWorldApplication implements CommandLineRunner {

    @Autowired
    private HelloWorldService helloWorldService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.helloWorldService.getHelloMessage());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}
