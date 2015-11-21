package moduleloader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ömer Ufuk Efendioglu
 */
@Controller
@RequestMapping("/")
public class ApplicationController {

    @RequestMapping
    public ModelAndView mainPage() {
        return new ModelAndView("index", "object", "lol");
    }
}
