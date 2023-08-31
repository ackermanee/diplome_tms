package by.controller;

import by.entity.Category;
import by.entity.Game;
import by.entity.GameCategoryMap;
import by.manager.CategoryManager;
import by.manager.GameCategoryMapManager;
import by.manager.GameManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class GameCategoryController {

    @Autowired
    private CategoryManager categoryManager;

    @Autowired
    private GameManager gameManager;

    @Autowired
    private GameCategoryMapManager gameCategoryMapManager;

    @GetMapping("/addGameToCategory")
    public String showAddGameToCategoryForm(Model model, ModelMap map) {
        List<Category> categories = categoryManager.getCategoryList();
        List<Game> games = gameManager.getGameList();

        model.addAttribute("categories", categories);
        model.addAttribute("games", games);
        model.addAttribute("gameCategoryMap", new GameCategoryMap());
        map.put("category", categoryManager.getCategory());
        map.put("game", gameManager.getGame());
        return "add-game-to-category-form";
    }

    @PostMapping("/addGameToCategory")
    public String addGameToCategory(@ModelAttribute GameCategoryMap gameCategoryMap,
                                    @RequestParam("category.id") int categoryId,
                                    @RequestParam("game.id") int gameId) {
        // Получите объекты Category и Game из базы данных по их id
        Category category = categoryManager.getById(categoryId);
        Game game = gameManager.getById(gameId);

        // Установите полученные объекты в gameCategoryMap
        gameCategoryMap.setCategory(category);
        gameCategoryMap.setGame(game);

        // Сохраните информацию о связи игры с категорией в базе данных
        gameCategoryMapManager.save(gameCategoryMap);
        return "redirect:/admin";
    }
}