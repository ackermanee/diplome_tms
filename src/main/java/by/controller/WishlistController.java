package by.controller;


import by.entity.Game;
import by.entity.Order;
import by.entity.User;
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
@RequestMapping("/wishlist")
public class WishlistController {


    @Autowired
    private UserManager userManager;

    @Autowired
    private GameManager gameManager;

    @GetMapping
    public String getLibrary(Principal principal, ModelMap map, @RequestParam(value = "error", required = false) String error) {
        User user = userManager.findByLogin(principal.getName());
        map.put("user", user);
        List<Game> game = gameManager.getGameList();
        map.put("game", game);
        return "wishlist";
    }

    @PostMapping("/addGameToWishlist/{id}")
    public String addGameToWihlist(Principal principal, ModelMap map, @PathVariable("id") Integer id) {
//        User user = userManager.findByLogin(principal.getName());
//        Game game = gameManager.getById(id);
//        List<Order> order = new ArrayList<Order>();
//        Game game = gameManager.addGame(id);
        return "redirect:/wishlist";
    }


}

