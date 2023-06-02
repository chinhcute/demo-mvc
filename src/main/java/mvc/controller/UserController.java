package mvc.controller;

import mvc.entity.CategoryEntity;
import mvc.formregistration.Gender;
import mvc.formregistration.User;

import mvc.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    CategoryRepository categoryRepository;
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
    public String showSesson( HttpServletRequest httpRequest, Model model){
       String users= (String) httpRequest.getSession().getAttribute("savedBook");
        model.addAttribute("users",users);
        return "sesson";
    }
    @RequestMapping(value = "/remove")
    public String remove( HttpServletRequest httpRequest, Model model){
        httpRequest.getSession().removeAttribute("savedBook");
        return "sesson";
    }
    @RequestMapping(value = "/from")
    public String inputCategory(Model model){
        model.addAttribute("categoryEntity",new CategoryEntity());
        return "category/from";
}
    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public String saveCategory(HttpSession session, CategoryEntity category){
        session.setAttribute("category", category);
        categoryRepository.save(category);
        return "redirect:/showCategories";
    }


    @RequestMapping(value = "/showCategories", method = RequestMethod.GET)
    public String showCategories(Model model) {
        List<CategoryEntity> categories = (List<CategoryEntity>) categoryRepository.findAll();

        if (categories.isEmpty()) {
            System.out.println("Danh sách categories rỗng");
        } else {
            System.out.println("Số lượng categories: " + categories.size());
        }

        model.addAttribute("categories", categories);
        return "category/categories";
    }



}
