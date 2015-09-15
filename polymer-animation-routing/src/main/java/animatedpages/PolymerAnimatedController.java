package animatedpages;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Ufuk on 15-09-15.
 */
@RestController
public class PolymerAnimatedController {

    @RequestMapping("/greeting")
    public Map<String, Object> greeting() {
        Map<String, Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello");
        return model;
    }
}
