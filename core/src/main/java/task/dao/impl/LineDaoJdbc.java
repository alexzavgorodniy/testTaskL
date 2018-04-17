package task.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import task.dao.EntityDao;
import task.exception.DaoException;
import task.model.Line;

public class LineDaoJdbc implements EntityDao<Line> {

    @Override
    public List<Line> findAll() {
        Connection connection = DaoFactoryJdbcImpl.getInstance().getConnection();
        try (PreparedStatement statementSelectAll = connection
                .prepareStatement("SELECT * FROM lines")) {
            ResultSet resultSet = statementSelectAll.executeQuery();
            return parseResultSet(resultSet);
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    private List<Line> parseResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<Line> lineList = new ArrayList<>();
        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String title = resultSet.getString(2);
            Integer longestWord = resultSet.getInt(3);
            Integer shortestWord = resultSet.getInt(4);
            Integer lineLendth = resultSet.getInt(5);
            Integer averageWordLength = resultSet.getInt(6);
            Line line = new Line();
            line.setId(id);
            line.setTitle(title);
            line.setLongestWord(longestWord);
            line.setShortestWord(shortestWord);
            line.setLineLength(lineLendth);
            line.setAverageWordLength(averageWordLength);
            lineList.add(line);
        }
        return lineList;
    }

    @Override
    public void addAllLines(List<Line> lines) {
        Connection connection = DaoFactoryJdbcImpl.getInstance().getConnection();
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
            throw new DaoException(e.getMessage());
        }
    }
}
