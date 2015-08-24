import hello.HelloWorldApplication;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ufuk on 24-08-15.
 */
public class HelloWorldApplicationTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultSettings() throws Exception {
        HelloWorldApplication.main(new String[0]);
        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("Hello Ufuk!"));
    }

    @Test
    public void testCommandLineOverrides() throws Exception {
        HelloWorldApplication.main(new String[]{"--user=Dude"});
        String output = this.outputCapture.toString();
        assertTrue("Wrong output: " + output, output.contains("Hello Dude!"));
    }
}
