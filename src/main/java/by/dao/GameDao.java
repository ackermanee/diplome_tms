package by.dao;

import by.entity.Category;
import by.entity.Game;
import by.entity.GameCategoryMap;
import by.manager.CategoryManager;
import by.manager.GameManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

@Repository
public class GameDao extends AbstractEntityDao{

    @Autowired
    private CategoryManager categoryManager;

//    @Autowired
//    private GameManager gameManager;



    public List<Game> getList() {
        List<Game> GameList;
        Session session = getSessionFactory().openSession();
        GameList = session.createQuery("FROM Game ").list();
        session.close();
        return GameList;
    }


//    public String deleteGame(int gameId) {
//
////        List<GameCategoryMap> gameCategoryMapList = gameCategoryMapDao.getList();
////        for (GameCategoryMap gameCategoryMap : gameCategoryMapList) {
////            if (gameCategoryMap.getCategory().getId() == gameId) {
////                gameCategoryMapDao.delete(gameCategoryMap);
////            }
////        }
////        List<Category> categoryList = gameDao.getList();
////        for (Game game : gameList) {
////            if (game.getId() == gameId) {
////                gameDao.delete(game);
////            }
////        }
//        Game game = gameManager.getById(gameId);
//        gameManager.delete(game);
//        return null;
//    }
}
