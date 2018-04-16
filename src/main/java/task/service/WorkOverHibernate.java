package task.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class WorkOverHibernate {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void dbConnection() {
        Session session = sessionFactory.openSession();
        new ParseFile().openFile(session);
        session.beginTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
