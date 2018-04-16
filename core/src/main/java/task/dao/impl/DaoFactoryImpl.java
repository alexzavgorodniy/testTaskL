package task.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import task.configJDBC.Config;
import task.dao.DaoFactory;
import task.dao.EntityDao;
import task.exception.DaoException;
import task.model.Line;

public final class DaoFactoryImpl implements DaoFactory {

    private static DaoFactoryImpl instance;

    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private EntityDao<Line> lineEntityDao;

    private DaoFactoryImpl() {
        try {
            Class.forName(Config.getInstance().driver());
        } catch (ClassNotFoundException e) {
            throw new DaoException(e.getMessage());
        }
    }

    public static DaoFactoryImpl getInstance() {
        if (instance == null) {
            instance = new DaoFactoryImpl();
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        try {
            Config config = Config.getInstance();
            return DriverManager.getConnection(config.url(), config.user(), config.password());
        } catch (SQLException e) {
            throw new DaoException("Could not create SQL Connection");
        }
    }

    @Override
    public EntityDao<Line> getLineDao() {
        if (lineEntityDao == null) {
            lineEntityDao = new LineDaoHibernate(factory);
        }
        return lineEntityDao;
    }

    @Override
    public EntityDao<Line> getLineDaoJdbc() {
        if (lineEntityDao == null) {
            lineEntityDao = new LineDaoJdbc(factory);
        }
        return lineEntityDao;
    }
}
