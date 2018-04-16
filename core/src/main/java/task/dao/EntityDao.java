package task.dao;

import java.util.List;

public interface EntityDao<T> {

    List<T> findAll();

    void addAllLines(List<T> lines);
}
