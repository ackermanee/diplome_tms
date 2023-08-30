package by.manager;


import by.dao.*;
//import by.dto.CategoryDTO;
import by.entity.Game;
import by.manager.CategoryManager;
import by.dto.UserDTO;
import by.entity.Category;
import by.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GameManager {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private CategoryManager categoryManager;
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
}
