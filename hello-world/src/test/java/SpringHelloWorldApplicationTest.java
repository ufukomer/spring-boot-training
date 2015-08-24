import hello.HelloWorldApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Ufuk on 24-08-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloWorldApplication.class)
public class SpringHelloWorldApplicationTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void testContextLoads() {
        assertNotNull(this.context);
        assertTrue(this.context.containsBean("helloWorldService"));
        assertTrue(this.context.containsBean("helloWorldApplication"));
    }
}
