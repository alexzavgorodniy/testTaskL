package task.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import task.model.Line;

class ParseTextFile {

    private Line lineOfText = new Line();

    void open(Connection connection) {
        String line;
        String path = "./sonet.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null) {
                lineOfText.setTitle(line);
                lineOfText = new LineStat().lineStatistics(lineOfText);
                new WorkOverJDBC().insertMethod(connection, lineOfText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}