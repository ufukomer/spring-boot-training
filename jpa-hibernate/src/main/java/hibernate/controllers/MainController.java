package hibernate.controllers;

import hibernate.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ufuk on 08-09-15.
 */
@Controller
public class MainController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return userDao.getAll().toString();
    }
}
