package task.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import task.configJDBC.Config;
import task.dao.EntityDao;
import task.dao.DaoFactory;
import task.exception.DaoException;
import task.model.Line;

public class DaoFactoryJdbcImpl implements DaoFactory<Connection> {

    private static DaoFactoryJdbcImpl instance;

    private EntityDao<Line> lineEntityDao;

    private DaoFactoryJdbcImpl() {
        try {
            Class.forName(Config.getInstance().driver());
        } catch (ClassNotFoundException e) {
            throw new DaoException(e.getMessage());
        }
    }

    public static DaoFactoryJdbcImpl getInstance() {
        if (instance == null) {
            instance = new DaoFactoryJdbcImpl();
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
            lineEntityDao = new LineDaoJdbc();
        }
        return lineEntityDao;
    }

    @Override
    public void closeConnection() {
        try {
            this.getConnection().close();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
