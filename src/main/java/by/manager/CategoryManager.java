package by.manager;


import by.dao.CategoryDao;
//import by.dto.CategoryDTO;
import by.manager.CategoryManager;
import by.dao.OrderDao;
import by.dao.ReviewDao;
import by.dao.UserDao;
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
public class CategoryManager {

    @Autowired
    private CategoryDao categoryDao;


    public void save(Category category) {
        categoryDao.save(category);
    }

    public void delete(Category category) {
        categoryDao.delete(category);
    }

    public Category getById(int id) {
        return categoryDao.getById(id, Category.class);
    }

    public List<Category> getCategory() {
        return categoryDao.getList();
    }

    public List<Category> getCategoryList() {
        return categoryDao.getList();
    }
    public void updateCategory(Category category) {
        categoryDao.update(category);
    }
    public void editCategory(Category category) {
        categoryDao.update(category);
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
