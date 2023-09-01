package by.dao;

import by.entity.Game;
import by.entity.Orderr;
import by.entity.User;
import by.manager.UserManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

@Repository
public class OrderDao extends AbstractEntityDao{

    @Autowired
    private UserManager userManager;

    @PersistenceContext
    private EntityManager entityManager;


    public List<Orderr> getList() {
        List<Orderr> OrdersList;
        Session session = getSessionFactory().openSession();
        OrdersList = session.createQuery("FROM Orderr").list();
        session.close();
        return OrdersList;
    }

    public Orderr getById(int id) {
        Session session = getSessionFactory().openSession();
        String queryString = "FROM Orderr WHERE id = :id";
        Query<Orderr> query = session.createQuery(queryString, Orderr.class);
        query.setParameter("id", id);
        Orderr orderr = query.uniqueResult();
        session.close();
        return orderr;
    }




//    public Orderr getOrderByUserId(Principal principal) {
//        User user = userManager.findByLogin(principal.getName());
//        int userId = user.getId();
//        Session session = getSessionFactory().openSession();
//        String queryString = "FROM Orderr WHERE user_id = :id";
//        Query<Orderr> query = session.createQuery(queryString, Orderr.class);
//        query.setParameter("id", id);
//        Orderr order = query.uniqueResult();
//        session.close();
//        return order;
//    }
}
