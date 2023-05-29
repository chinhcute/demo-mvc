package mvc.controller;

import mvc.formregistration.Gender;
import mvc.formregistration.User;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private static final String[] countries = {"Viet Nam", "United States","Germany"};
    @RequestMapping(value = "/register")
    public String showRegisForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("countries", countries);
        return "regisForm/userForm";
    }
    @RequestMapping(value = "/result")
    public String processUser(User user, HttpSession httpSession){
      httpSession.setAttribute("savedBook",user.getName());
        return "regisForm/userResult";
    }
    @RequestMapping(value = "/seson")
    public String showSesson( HttpServletRequest httpRequest){
        httpRequest.getSession().getAttribute("savedBook");

        return "sesson";
    }
}
