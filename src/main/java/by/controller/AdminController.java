package by.controller;

import by.dao.CategoryDao;
import by.dao.GameDao;
import by.dao.UserDao;
import by.dto.CategoryDTO;
import by.dto.GameDTO;
import by.dto.UserDTO;
import by.entity.Category;
import by.entity.Game;
import by.entity.User;
import by.manager.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping
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
    private GameManager gameManager;


    @GetMapping("/admin")
    public String getUserList(Principal principal, ModelMap map) {
        User user = userManager.findByLogin(principal.getName());

        map.put("user", user);
        map.put("categories", categoryManager.getCategory());
        map.put("game", gameManager.getGame());
        map.put("logs", adminManager.getUsersLog());
        map.put("users", userManager.getUsers());
        return "adminPanel";
    }


    @GetMapping("/admin/deleteUser")
    public String deleteUserById (@RequestParam("id") int userId) {
        User user = userManager.getById(userId);
        userDao.deleteUser(userId);
        log.info("Пользователь " + user.getLogin() + " был удален из системы");
        return "redirect:/admin";
    }

    @GetMapping("/admin/deleteCategory")
    public String deleteCategoryById (@RequestParam("id") int categoryId) {
        Category category = categoryManager.getById(categoryId);
        categoryDao.deleteCategory(categoryId);
        log.info("Категория " + category.getCategoryName() + " была удалена из системы");
        return "redirect:/admin";
    }

    @GetMapping("/admin/deleteGame")
    public String deleteGameById (@RequestParam("id") int gameId) {
        Game game = gameManager.getById(gameId);
        gameManager.deleteGame(gameId);
        log.info("Игра " + game.getName() + " была удалена из системы");
        return "redirect:/admin";
    }


    @GetMapping("/admin/editGame{id}")
    public String editProfilePage(@RequestParam("id") int gameId, Principal principal, ModelMap map) {
      Game game = gameManager.getById(gameId);
        map.put("gameDTO", new GameDTO());

        // UserDTO инициализируется данными текущего пользователя
        return "editGame";
    }

    @PostMapping("/admin/editGame{id}")
    public String editProfile(@RequestParam("id") int gameId, @ModelAttribute GameDTO gameDTO, ModelMap map, Principal principal) {
        Game game = gameManager.getById(gameId);
        game.setName(gameDTO.getName());
        game.setDeveloper(gameDTO.getDeveloper());
        game.setPrice(gameDTO .getPrice());
            // Сохранение обновленных данных пользователя в базе данных
        gameManager.editCategory(game);
        map.put("game", game);
        map.put("gameDTO", new GameDTO());

        return "redirect:/admin";
    }




    @GetMapping("/admin/editCategory{id}")
    public String editCategory(@RequestParam("id") int categoryId, Principal principal, ModelMap map) {
        Category category = categoryManager.getById(categoryId);
//        Game game = gameManager.getById(gameId);
        map.put("categoryDTO", new CategoryDTO());

        // UserDTO инициализируется данными текущего пользователя
        return "editCategory";
    }

    @PostMapping("/admin/editCategory{id}")
    public String editCategory(@RequestParam("id") int categoryId, @ModelAttribute CategoryDTO categoryDTO, ModelMap map, Principal principal) {
        Category category = categoryManager.getById(categoryId);
//        Game game = gameManager.getById(gameId);

        category.setCategoryName(categoryDTO.getCategoryName());
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        // Сохранение обновленных данных пользователя в базе данных
        categoryManager.editCategory(category);
        map.put("category", category);
        map.put("categoryDTO", new CategoryDTO());

        return "redirect:/admin";
    }











    @GetMapping("/admin/addGame")
    public String editCategory(ModelMap map) {
        map.put("gameDTO", new GameDTO());
        return "createGame";
    }


    @PostMapping("/admin/addGame")
    public String createProduct(@ModelAttribute GameDTO gameDTO) {
        gameManager.save(gameManager.toGame(gameDTO));
        log.info("Игра " + gameDTO.getName() + " создана");
        return "redirect:/admin";
    }
}


