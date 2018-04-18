package task.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import task.dao.EntityDao;
import task.model.ReadFile;

public class FilesDaoHibernate implements EntityDao<ReadFile> {

    private DaoFactoryHiberImpl factoryHiber = new DaoFactoryHiberImpl();

    @Override
    public List<ReadFile> findAll() {
        ArrayList<ReadFile> lineList = new ArrayList<>();
        Session session = factoryHiber.getConnection().openSession();
        List<ReadFile> resultList = session.createQuery("SELECT rf FROM ReadFile rf", ReadFile.class)
                .getResultList();
        lineList.addAll(resultList);
        session.close();
        return lineList;
    }

    @Override
    public void addAllEntities(List<ReadFile> readFiles) {
        Session session = factoryHiber.getConnection().openSession();
        session.beginTransaction();
        readFiles.forEach(session::merge);
        session.getTransaction().commit();
        session.close();
    }

    public ReadFile findOneByFileId(Integer fileId) {
        Session session = factoryHiber.getConnection().openSession();
        session.beginTransaction();
        ReadFile readFile = session.find(ReadFile.class, fileId);
        session.close();
        return readFile;
    }
}
