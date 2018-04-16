package task.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.SessionFactory;
import task.dao.EntityDao;
import task.model.Line;

public class LineDaoJdbc implements EntityDao<Line> {

    private final SessionFactory factory;

    LineDaoJdbc(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Line> findAll() {
        return null;
    }

    @Override
    public void addAllLines(List<Line> lines) {
        DaoFactoryImpl factory = DaoFactoryImpl.getInstance();
        Connection connection = factory.getConnection();
        try (PreparedStatement statementInsert = connection.prepareStatement(
                "INSERT INTO lines (title, longest_word, shortest_word, line_length, average_word_length) VALUES(?, ?, ?, ?, ?)")) {
            for (Line line : lines) {
                statementInsert.setString(1, line.getTitle());
                statementInsert.setInt(2, line.getLongestWord());
                statementInsert.setInt(3, line.getShortestWord());
                statementInsert.setInt(4, line.getLineLength());
                statementInsert.setInt(5, line.getAverageWordLength());
                statementInsert.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
