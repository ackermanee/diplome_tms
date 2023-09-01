package by.controller;


import by.dao.OrderDao;
import by.entity.*;
import by.manager.GameManager;
import by.manager.OrderManager;
import by.manager.OrderTypeManager;
import by.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping
public class WishlistController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private GameManager gameManager;

    @Autowired
    private OrderManager orderManager;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderTypeManager orderTypeManager;

    @GetMapping("/wishlist")
    public String getLibrary(Principal principal, ModelMap map, @RequestParam(value = "error", required = false) String error) {
        User user = userManager.findByLogin(principal.getName());
        List<Orderr> orderrList = orderManager.getOrder();
        List<Game> gameList = new ArrayList<>();
        for (Orderr orderr : orderrList) {
            if (orderr.getUser().equals(user)) {
                Game game = orderr.getGame();
                gameList.add(game);
            }
        }
        map.put("user", user);
        map.put("game", gameList);
        return "wishlist";
    }

    @PostMapping("/remove-game{id}")
    @Transactional
    public String removeGame(@RequestParam("id") int gameId, Principal principal) {
        User user = userManager.findByLogin(principal.getName());
        Game game = gameManager.getById(gameId);
        entityManager.createQuery("DELETE FROM Orderr o WHERE o.user = :user AND o.game.id = :gameId")
                .setParameter("user", user)
                .setParameter("gameId", gameId)
                .executeUpdate();
        log.info("Игра " + game.getName() + " была удалена из списка желаемого пользователя " + user.getLogin());
        return "redirect:/wishlist";
    }

    @PostMapping("/addGameToOrder{id}")
    public String addGameToOrder(@RequestParam("gameId") int gameId, Principal principal) {
        Game game = gameManager.getById(gameId);
        OrderType orderType = orderTypeManager.getById(1);
        User user = userManager.findByLogin(principal.getName());

        if (game != null) {
            Orderr orderr = new Orderr();
            orderr.setGame(game);
            orderr.setUser(user);
            orderr.setOrderType(orderType);
            orderManager.save(orderr);
        }
        log.info("Игра " + game.getName() + " была добавлена в список желаемого пользователя " + user.getLogin());
        return "redirect:/wishlist";
    }
}