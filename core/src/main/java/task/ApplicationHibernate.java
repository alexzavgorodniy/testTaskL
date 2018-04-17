package task;

import java.util.List;
import task.dao.impl.DaoFactoryHiberImpl;
import task.model.Line;
import task.service.ParseFile;

public class ApplicationHibernate {

    public static void main(String[] args) {
        DaoFactoryHiberImpl factory = new DaoFactoryHiberImpl();
        List<Line> lines = new ParseFile().openFile();
        factory.getLineDao().addAllLines(lines);
        factory.closeConnection();
    }
}
