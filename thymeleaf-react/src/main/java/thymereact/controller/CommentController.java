package thymereact.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import thymereact.model.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ömer Ufuk Efendio?lu
 */
@Controller
@RequestMapping("/")
public class CommentController {

    @RequestMapping
    public ModelAndView list(ModelMap modelMap) {
        List<Comment> comments = new ArrayList<>();
        Comment comment1 = new Comment((long) 1, "React is awesome!", "React FTW!");
        Comment comment2 = new Comment((long) 2, "Thymeleaf cannot bind external javascript.", "Thymeleaf");
        Comment comment3 = new Comment((long) 3, "I love Spring Boot.", "Spring Boot");
        Comment comment4 = new Comment((long) 4, "Spring Boot 1.3.0 release on the way.", "Spring Boot Release Data?");

        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);
        comments.add(comment4);

        String json = new Gson().toJson(comments);
        modelMap.addAttribute("hello", json);

        return new ModelAndView("comments/list", "comments", comments);
    }
}
