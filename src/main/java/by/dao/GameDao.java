package by.dao;

import by.entity.Game;
import org.hibernate.Session;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

public class GameDao extends AbstractEntityDao{
    public List<Game> getList() {
        List<Game> GameList;
        Session session = getSessionFactory().openSession();
        GameList = session.createQuery("FROM Game ").list();
        session.close();
        return GameList;
    }
}
