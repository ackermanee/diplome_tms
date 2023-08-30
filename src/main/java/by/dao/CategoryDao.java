package by.dao;

import by.entity.*;
import by.manager.CategoryManager;
import by.manager.UserManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

@Repository

public class CategoryDao extends AbstractEntityDao{

    @Autowired
    private CategoryManager categoryManager;

    @Autowired
    private GameCategoryMapDao gameCategoryMapDao;

    @Autowired
    private GameDao gameDao;

    public List<Category> getList() {
        List<Category> categoryList;
        Session session = getSessionFactory().openSession();
        categoryList = session.createQuery("FROM Category ").list();
        session.close();
        return categoryList;
    }

    public Category getById(int id) {
        Session session = getSessionFactory().openSession();
        String queryString = "FROM Category WHERE id = :id";
        Query<Category> query = session.createQuery(queryString, Category.class);
        query.setParameter("id", id);
        Category category = query.uniqueResult();
        session.close();
        return category;
    }


    public String deleteCategory(int categoryId) {
        List<GameCategoryMap> gameCategoryMapList = gameCategoryMapDao.getList();
        for (GameCategoryMap gameCategoryMap : gameCategoryMapList) {
            if (gameCategoryMap.getCategory().getId() == categoryId) {
                gameCategoryMapDao.delete(gameCategoryMap);
            }
        }
        List<Game> gameList = gameDao.getList();
        for (Game game : gameList) {
            if (game.getId() == categoryId) {
                gameDao.delete(game);
            }
        }
        Category category = categoryManager.getById(categoryId);
        categoryManager.delete(category);
        return null;
    }
}
