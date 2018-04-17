package task.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import task.dao.EntityDao;
import task.dao.DaoFactory;
import task.model.Line;

public class DaoFactoryHiberImpl implements DaoFactory<SessionFactory> {

    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private EntityDao<Line> lineEntityDao;

    public DaoFactoryHiberImpl() {
    }

    @Override
    public SessionFactory getConnection() {
        return factory;
    }

    @Override
    public EntityDao<Line> getLineDao() {
        if (lineEntityDao == null) {
            lineEntityDao = new LineDaoHibernate();
        }
        return lineEntityDao;
    }

    @Override
    public void closeConnection() {
        factory.close();
    }
}
