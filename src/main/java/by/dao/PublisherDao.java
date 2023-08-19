package by.dao;


import by.entity.Publisher;
import org.hibernate.Session;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

public class PublisherDao extends AbstractEntityDao{
    public List<Publisher> getList() {
        List<Publisher> PublisherList;
        Session session = getSessionFactory().openSession();
        PublisherList = session.createQuery("FROM Publisher ").list();
        session.close();
        return PublisherList;
    }
}
