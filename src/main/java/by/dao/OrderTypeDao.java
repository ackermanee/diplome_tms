package by.dao;

import by.entity.OrderType;
import org.hibernate.Session;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

public class OrderTypeDao extends AbstractEntityDao{
    public List<OrderType> getList() {
        List<OrderType> OrderTypeList;
        Session session = getSessionFactory().openSession();
        OrderTypeList = session.createQuery("FROM OrderType ").list();
        session.close();
        return OrderTypeList;
    }
}
