package task;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.h2.tools.RunScript;
import task.dao.impl.DaoFactoryImpl;
import task.model.Line;
import task.service.ParseFile;

public class ApplicationJdbc {

    public static void main(String[] args) {
        DaoFactoryImpl factory = DaoFactoryImpl.getInstance();
        Connection connection = factory.getConnection();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream stream = classLoader.getResourceAsStream("sql/init.sql");
                InputStreamReader reader = new InputStreamReader(stream)) {
            RunScript.execute(connection, reader);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        List<Line> lines = new ParseFile().openFile();
        factory.getLineDaoJdbc().addAllLines(lines);
    }

}
