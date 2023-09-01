package by.config;

import by.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class FactoryManager {

    private static volatile FactoryManager instance;
    private static SessionFactory sessionFactory;

    private FactoryManager() {
    }

    public static SessionFactory getSessionFactory() {

        if (instance != null) {
            return sessionFactory;
        }
        synchronized (FactoryManager.class) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Category.class);
            configuration.addAnnotatedClass(Game.class);
            configuration.addAnnotatedClass(GameCategoryMap.class);
            configuration.addAnnotatedClass(Orderr.class);
            configuration.addAnnotatedClass(OrderType.class);
            configuration.addAnnotatedClass(Publisher.class);
            configuration.addAnnotatedClass(Review.class);
            configuration.addAnnotatedClass(User.class);
            configuration.configure();
            StandardServiceRegistry registryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(registryBuilder);
            instance = new FactoryManager();
        }
        return sessionFactory;
    }
}
