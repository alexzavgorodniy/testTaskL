package task.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.h2.tools.RunScript;
import task.configJDBC.Configuration;
import task.model.Line;

public class WorkOverJDBC {

    private ParseTextFile parseTextFile = new ParseTextFile();

    public void dbConnection() {
        Configuration config = Configuration.getInstance();
        try {
            Class.forName(config.driver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager
                .getConnection(config.url(), config.user(), config.password())) {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            try (InputStream stream = classLoader.getResourceAsStream("sql/init.sql");
                    InputStreamReader reader = new InputStreamReader(stream)) {
                RunScript.execute(connection, reader);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
            parseTextFile.open(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertMethod(Connection connection, Line lineOfText) {
        try (PreparedStatement statementInsert = connection.prepareStatement(
                "INSERT INTO lines (title, longest_word, shortest_word, line_length, average_word_length) VALUES(?, ?, ?, ?, ?)")) {
            statementInsert.setString(1, lineOfText.getTitle());
            statementInsert.setInt(2, lineOfText.getLongestWord());
            statementInsert.setInt(3, lineOfText.getShortestWord());
            statementInsert.setInt(4, lineOfText.getLineLength());
            statementInsert.setInt(5, lineOfText.getAverageWordLength());
            statementInsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
