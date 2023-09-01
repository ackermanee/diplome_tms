package by.dao;

import by.entity.OrderType;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

@Repository
public class OrderTypeDao extends AbstractEntityDao{
    public List<OrderType> getList() {
        List<OrderType> OrderTypeList;
        Session session = getSessionFactory().openSession();
        OrderTypeList = session.createQuery("FROM OrderType ").list();
        session.close();
        return OrderTypeList;
    }


    public OrderType getById(int id) {
        Session session = getSessionFactory().openSession();
        String queryString = "FROM Orderr WHERE id = :id";
        Query<OrderType> query = session.createQuery(queryString, OrderType.class);
        query.setParameter("id", id);
        OrderType orderType = query.uniqueResult();
        session.close();
        return orderType;
    }

}
