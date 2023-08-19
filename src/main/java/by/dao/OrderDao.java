package by.dao;

import by.entity.Order;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

@Repository
public class OrderDao extends AbstractEntityDao{
    public List<Order> getList() {
        List<Order> OrdersList;
        Session session = getSessionFactory().openSession();
        OrdersList = session.createQuery("FROM Order").list();
        session.close();
        return OrdersList;
    }

    public Order getById(int id) {
        Session session = getSessionFactory().openSession();
        String queryString = "FROM Order WHERE id = :id";
        Query<Order> query = session.createQuery(queryString, Order.class);
        query.setParameter("id", id);
        Order order = query.uniqueResult();
        session.close();
        return order;
    }
}
