package by.manager;


import by.dao.*;
//import by.dto.CategoryDTO;
import by.entity.Game;
import by.entity.GameCategoryMap;
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
public class GameCategoryMapManager {

    @Autowired
    private GameCategoryMapDao gameCategoryMapDao;

    @Autowired
    private CategoryManager categoryManager;
    public void save(GameCategoryMap gameCategoryMap) {
        gameCategoryMapDao.save(gameCategoryMap);
    }

    public void delete(GameCategoryMap gameCategoryMap) {
        gameCategoryMapDao.delete(gameCategoryMap);
    }

    public GameCategoryMap getById(int id) {
        return gameCategoryMapDao.getById(id, GameCategoryMap.class);
    }

    public List<GameCategoryMap> getGameCategoryMap() {
        return gameCategoryMapDao.getList();
    }


    public void updateCategory(GameCategoryMap gameCategoryMap) {
        gameCategoryMapDao.update(gameCategoryMap);
    }
    public void editCategory(GameCategoryMap gameCategoryMap) {
        gameCategoryMapDao.update(gameCategoryMap);
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
