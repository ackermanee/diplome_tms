package by.dao;

import by.entity.Review;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

@Repository
public class ReviewDao extends AbstractEntityDao{
    public List<Review> getList() {
        List<Review> ReviewList;
        Session session = getSessionFactory().openSession();
        ReviewList = session.createQuery("FROM Review ").list();
        session.close();
        return ReviewList;
    }


}
