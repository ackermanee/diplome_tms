package by.controller;

import by.dao.CategoryDao;
import by.dao.UserDao;
import by.entity.Category;
import by.entity.User;
import by.manager.AdminManager;
import by.manager.CategoryManager;
import by.manager.ReviewManager;
import by.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserManager userManager;


    @Autowired
    private CategoryManager categoryManager;



    @Autowired
    private UserDao userDao;


    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private AdminManager adminManager;

    @Autowired
    private ReviewManager reviewManager;

    @GetMapping
    public String getUserList(Principal principal, ModelMap map) {
        User user = userManager.findByLogin(principal.getName());

        map.put("user", user);
        map.put("categories", categoryManager.getCategory());
        map.put("logs", adminManager.getUsersLog());
        map.put("users", userManager.getUsers());
        return "adminPanel";
    }



//    @GetMapping("/delete")
//    public String deleteUser(@RequestParam("id") int userId, RedirectAttributes redirectAttributes) {
//        User user = userManager.getById(userId);
//        Order order = ordersManager.getById(userId);
//        Review review = reviewManager.getById(userId);
//        if (order.getId() == userId) {
//            if (review.getId() == userId) {
//                ordersManager.delete(order);
//                reviewManager.delete(review);
//                userManager.delete(user);
//                log.info("Пользователь " + user.getLogin() + " был удален из системы");
//                return "redirect:/admin";
//            } else {
//                FieldError fieldError = new FieldError("product", "id", "нельзя удалить товар " +
//                        "который используется");
//                redirectAttributes.addFlashAttribute("errors", fieldError);
//                return "redirect:/admin";
//            }
//        }
//        else {
//            FieldError fieldError = new FieldError("product", "id", "нельзя удалить товар " +
//                    "который используется");
//            redirectAttributes.addFlashAttribute("errors", fieldError);
//            return "redirect:/admin";
//        }
//    }

    @GetMapping("/delete")
    public String deleteUserById (@RequestParam("id") int userId) {
        User user = userManager.getById(userId);
        userDao.deleteUser(userId);
        log.info("Пользователь " + user.getLogin() + " был удален из системы");
        return "redirect:/admin";
    }

    @GetMapping("/deleteCategory")
    public String deleteCategoryById (@RequestParam("id") int categoryId) {
        Category category = categoryManager.getById(categoryId);
        categoryDao.deleteCategory(categoryId);
        log.info("Категория " + category.getCategoryName() + " была удалена из системы");
        return "redirect:/admin";
    }
}


