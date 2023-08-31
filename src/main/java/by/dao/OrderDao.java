package by.dao;

import by.entity.Order;
import by.entity.User;
import by.manager.UserManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

@Repository
public class OrderDao extends AbstractEntityDao{

    @Autowired
    private UserManager userManager;

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

//
//    public Order getOrderByUserId(Principal principal) {
//        User user = userManager.findByLogin(principal.getName());
//        int userId = user.getId();
//        Session session = getSessionFactory().openSession();
//        String queryString = "FROM Order WHERE user_id = :id";
//        Query<Order> query = session.createQuery(queryString, Order.class);
//        query.setParameter("id", id);
//        Order order = query.uniqueResult();
//        session.close();
//        return order;
//    }
}
