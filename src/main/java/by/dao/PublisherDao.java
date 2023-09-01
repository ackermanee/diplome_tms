package by.dao;


import by.entity.Publisher;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;


@Repository
public class PublisherDao extends AbstractEntityDao{
    public List<Publisher> getList() {
        List<Publisher> PublisherList;
        Session session = getSessionFactory().openSession();
        PublisherList = session.createQuery("FROM Publisher ").list();
        session.close();
        return PublisherList;
    }


    public Publisher getById(int id) {
        Session session = getSessionFactory().openSession();
        String queryString = "FROM Publisher WHERE id = :id";
        Query<Publisher> query = session.createQuery(queryString, Publisher.class);
        query.setParameter("id", id);
        Publisher publisher = query.uniqueResult();
        session.close();
        return publisher;
    }
}
