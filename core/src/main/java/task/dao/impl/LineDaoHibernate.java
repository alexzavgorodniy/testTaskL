package task.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import task.dao.EntityDao;
import task.model.Line;

public class LineDaoHibernate implements EntityDao<Line> {

    private DaoFactoryHiberImpl factoryHiber = new DaoFactoryHiberImpl();

    @Override
    public List<Line> findAll() {
        ArrayList<Line> lineList = new ArrayList<>();
        Session session = factoryHiber.getConnection().openSession();
        List<Line> resultList = session.createQuery("SELECT li FROM Line li", Line.class)
                .getResultList();
        lineList.addAll(resultList);
        session.close();
        return lineList;
    }

    @Override
    public void addAllEntities(List<Line> lines) {
        Session session = factoryHiber.getConnection().openSession();
        session.beginTransaction();
        lines.forEach(session::merge);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Line findOneByFileId(Integer id) {
        return null;
    }

    public List<Line> findAllLinesByFileId(Integer id) {
        Session session = factoryHiber.getConnection().openSession();
        session.beginTransaction();
        Query<Line> query = session
                .createQuery("SELECT li FROM Line li WHERE readfile_id=:id", Line.class);
        query.setParameter("id",id);
        List<Line> resultList = query.getResultList();
        session.close();
        return resultList;
    }
}
