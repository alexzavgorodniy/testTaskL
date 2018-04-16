package task.dao;

import java.sql.Connection;
import task.model.Line;

public interface DaoFactory {

    Connection getConnection();

    EntityDao<Line> getLineDao();
    EntityDao<Line> getLineDaoJdbc();
}
