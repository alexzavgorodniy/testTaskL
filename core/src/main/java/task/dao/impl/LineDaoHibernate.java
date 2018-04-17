package task.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
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
    public void addAllLines(List<Line> lines) {
        Session session = factoryHiber.getConnection().openSession();
        session.beginTransaction();
        lines.forEach(session::merge);
        session.getTransaction().commit();
        session.close();
    }
}
