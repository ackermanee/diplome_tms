package by.dao;

import by.entity.Category;
import org.hibernate.Session;

import java.util.List;

import static by.config.FactoryManager.getSessionFactory;

public class CategoryDao extends AbstractEntityDao{
    public List<Category> getList() {
        List<Category> categoryList;
        Session session = getSessionFactory().openSession();
        categoryList = session.createQuery("FROM Category ").list();
        session.close();
        return categoryList;
    }
}
