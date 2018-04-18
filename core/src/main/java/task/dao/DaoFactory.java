package task.dao;

import task.model.Line;

public interface DaoFactory<T> {

    T getConnection();

    EntityDao<Line> getLineDao();

    void closeConnection();
}
