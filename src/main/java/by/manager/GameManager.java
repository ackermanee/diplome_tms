package by.manager;


import by.dao.*;
//import by.dto.CategoryDTO;
import by.dto.GameDTO;
import by.entity.*;
import by.manager.CategoryManager;
import by.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GameManager {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserManager userManager;

    @Autowired
    private GameManager gameManager;

    @Autowired
    private PublisherManager publisherManager;

    public Game toGame(GameDTO gameDTO) {
        Game game = new Game();
        Publisher publisher = publisherManager.getById(1);
        game.setName(gameDTO.getName());
        game.setDeveloper(gameDTO.getDeveloper());
        game.setPrice(gameDTO.getPrice());
        game.setPublisher(publisher); // Уст
        return game;
    }
    public void save(Game game) {


        gameDao.save(game);
    }

    public void delete(Game game) {
        gameDao.delete(game);
    }

    public Game getById(int id) {
        return gameDao.getById(id, Game.class);
    }


    public List<Game> getGame() {
        return gameDao.getList();
    }

    public List<Game> getGameList() {
        return gameDao.getList();
    }
    public void updateCategory(Game game) {
        gameDao.update(game);
    }
    public void editCategory(Game game) {
        gameDao.update(game);
    }

//    public void saveCategory(CategoryDTO categoryDto) {
//        Category category = new Category();
////        DeliveryProductMap deliveryProductMap = new DeliveryProductMap();
////        DeliveryStatus deliveryStatus = deliveryStatusDao.getById(1, DeliveryStatus.class);
//
//        category.setCategoryName(categoryDto.getCategoryName());
//        category.setCategoryDescription((categoryDto.getCategoryDescription()));
//        System.out.println(category);
//        categoryDao.save(category);
////        for (int i = 0; i < productList.size(); i++) {
////            deliveryProductMap.setDelivery(delivery);
////            deliveryProductMap.setProduct(productManager.getById(productList.get(i).getProductId()));
////            deliveryProductMap.setQuantity(productList.get(i).getQuantity());
////            deliveryProductMapDao.save(deliveryProductMap);
////        }
////        productList.clear();
//    }
public String deleteGame(int gameId) {

//        List<GameCategoryMap> gameCategoryMapList = gameCategoryMapDao.getList();
//        for (GameCategoryMap gameCategoryMap : gameCategoryMapList) {
//            if (gameCategoryMap.getCategory().getId() == gameId) {
//                gameCategoryMapDao.delete(gameCategoryMap);
//            }
//        }
//        List<Category> categoryList = gameDao.getList();
//        for (Game game : gameList) {
//            if (game.getId() == gameId) {
//                gameDao.delete(game);
//            }
//        }
    Game game = gameManager.getById(gameId);
    gameManager.delete(game);
    return null;
}


}
