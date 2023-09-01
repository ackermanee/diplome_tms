package by.controller;

import by.dao.CategoryDao;
import by.entity.Category;
import by.entity.Game;
import by.entity.GameCategoryMap;
import by.entity.User;
import by.manager.CategoryManager;
import by.manager.GameCategoryMapManager;
import by.manager.GameManager;
import by.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private GameCategoryMapManager gameCategoryMapManager;

    @Autowired
    private GameManager gameManager;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryManager categoryManager;

    @GetMapping("/categories")
    public String getCategories(Principal principal, ModelMap map) {
        User user = userManager.findByLogin(principal.getName());
        map.put("user", user);
        List<Category> category = categoryManager.getCategoryList();
        map.put("categories", category);
        List<GameCategoryMap> gameCategoryMap = gameCategoryMapManager.getGameCategoryMap();
        map.put("gameCategoryMap", gameCategoryMap);
        List<Game> game = gameManager.getGameList();
        map.put("game", game);
        return "categories";
    }


    @GetMapping("/delete")
    public String deleteCategoryById (@RequestParam("id") int categoryId) {
        Category category = categoryManager.getById(categoryId);
        categoryDao.deleteCategory(categoryId);
        log.info("Категория " + category.getCategoryName() + " была удалена из системы");
        return "redirect:/category";
    }

    @GetMapping("/categoryGame")
    public String getLibrary(@RequestParam(value = "id") Integer id, ModelMap map, Principal principal) {
        User user = userManager.findByLogin(principal.getName());
        map.put("user", user);
        Category category = categoryManager.getById(id);
        map.put("category", category);
        List<GameCategoryMap> gameCategoryMapList = category.getGameCategoryMaps();
        List<Game> gameList = new ArrayList<>();
        for (GameCategoryMap gameCategoryMap: gameCategoryMapList) {
            Game game = gameCategoryMap.getGame();
            gameList.add(game);
        }
        map.put("game", gameList);
        return "categoryGame";
    }

    @PostMapping("/categoryGame")
    public String updateDelivery(@ModelAttribute Category category) {
        return "redirect:/category/categoryGame?id=" + category.getId();
    }
}

