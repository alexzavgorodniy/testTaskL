package task.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import task.dao.EntityDao;
import task.model.Line;

public class LineDaoHibernate implements EntityDao<Line> {

    private final SessionFactory factory;

    LineDaoHibernate(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Line> findAll() {
        ArrayList<Line> lineList = new ArrayList<>();
        Session session = factory.openSession();
        List<Line> resultList = session.createQuery("SELECT li FROM Line li", Line.class)
                .getResultList();
        lineList.addAll(resultList);
        session.close();
        return lineList;
    }

    @Override
    public void addAllLines(List<Line> lines) {
        Session session = factory.openSession();
        session.beginTransaction();
        lines.forEach(session::merge);
        session.getTransaction().commit();
        session.close();
    }
}
