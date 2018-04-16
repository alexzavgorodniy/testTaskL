package task.service;

import java.io.BufferedReader;
import java.io.FileReader;
import org.hibernate.Session;
import task.model.Line;

class ParseFile {

    private Line lineOfText = new Line();

    void openFile(Session session) {
        String line;
        String path = "./sonet.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null) {
                lineOfText.setTitle(line);
                lineOfText = new LineStat().lineStatistics(lineOfText);
                session.merge(lineOfText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
