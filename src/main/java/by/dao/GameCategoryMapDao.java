package by.dao;

import by.entity.GameCategoryMap;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;


@Repository
public class GameCategoryMapDao extends AbstractEntityDao{
    public List<GameCategoryMap> getList() {
        List<GameCategoryMap> GameCategoryMapList;
        Session session = getSessionFactory().openSession();
        GameCategoryMapList = session.createQuery("FROM GameCategoryMap ").list();
        session.close();
        return GameCategoryMapList;
    }
}
