package hibernate;

import hibernate.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

/**
 * Created by Ufuk on 08-09-15.
 */
@SpringBootApplication
// Not essential, Spring Boot tries to guess the location otherwise
@EntityScan(basePackageClasses = User.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
