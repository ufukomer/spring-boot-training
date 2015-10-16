package thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import thymeleaf.model.Animal;

import java.util.Date;

/**
 * Created by Ufuk on 15-10-15.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index(ModelMap modelMap) {
        Date date = new Date();
        modelMap.addAttribute("date", date);
        return "index";
    }

    @RequestMapping("/login")
    public String login(ModelMap modelMap) {
        Animal animal = new Animal();
        modelMap.addAttribute("animal", animal);
        return "login";
    }

    @RequestMapping("/show")
    public String show(@ModelAttribute Animal animal) {
        return "index";
    }
}
