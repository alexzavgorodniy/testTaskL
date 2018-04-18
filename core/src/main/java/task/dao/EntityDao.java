package task.dao;

import java.util.List;

public interface EntityDao<T> {

    List<T> findAll();

    void addAllEntities(List<T> entity);

    T findOneByFileId(Integer id);
}
