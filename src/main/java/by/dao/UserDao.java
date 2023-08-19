package by.dao;

import by.entity.Order;
import by.entity.Review;
import by.entity.User;
import by.manager.OrderManager;
import by.manager.UserManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;


@Repository

public class UserDao extends AbstractEntityDao {

    @Autowired
    private OrderManager orderManager;

    @Autowired
    private UserManager userManager;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ReviewDao reviewDao;
    public String deleteUser(int userId) {
        List<Review> reviewList = reviewDao.getList();
        for (Review review : reviewList) {
            if (review.getUser().getId() == userId) {
                reviewDao.delete(review);
            }
        }
        List<Order> orderList = orderDao.getList();
        for (Order order : orderList) {
            if (order.getUser().getId() == userId) {
                orderDao.delete(order);
            }
        }
        User user = userManager.getById(userId);
        userManager.delete(user);
        return null;
    }

    public List<User> getList() {
        List<User> userList;
        Session session = getSessionFactory().openSession();
        userList = session.createQuery("FROM User ").list();
        session.close();
        return userList;
    }
    public User getByLogin(String login) {
        Session session = getSessionFactory().openSession();
        String queryString = "FROM User WHERE login = :login";
        Query<User> query = session.createQuery(queryString, User.class);
        query.setParameter("login", login);
        User user = query.uniqueResult();
        session.close();
        return user;
    }

    public User getByEmail (String email) {
        Session session = getSessionFactory().openSession();
        String queryString = "FROM User WHERE email = :email";
        Query<User> query = session.createQuery(queryString, User.class);
        query.setParameter("email", email);
        User user = query.uniqueResult();
        session.close();
        return user;
    }


    public User getByRole (String role) {
        Session session = getSessionFactory().openSession();
        String queryString = "FROM User WHERE role = :role";
        Query<User> query = session.createQuery(queryString, User.class);
        query.setParameter("role", role);
        User user = query.uniqueResult();
        session.close();
        return user;
    }

}
