package task;

import java.util.List;
import task.dao.impl.DaoFactoryImpl;
import task.model.Line;
import task.service.ParseFile;

public class ApplicationHibernate {

    public static void main(String[] args) {
        DaoFactoryImpl factory = DaoFactoryImpl.getInstance();
        List<Line> lines = new ParseFile().openFile();
        factory.getLineDao().addAllLines(lines);
    }
}