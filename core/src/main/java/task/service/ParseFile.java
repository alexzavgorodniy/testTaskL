package task.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import task.model.Line;

public class ParseFile {

    public List<Line> openFile() {
        String line;
        String path = "sonet.txt";
        List<Line> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null) {
                Line lineOfText = new Line();
                lineOfText.setTitle(line);
                lineOfText = new LineStatistics().lineStatistics(lineOfText);
                lines.add(lineOfText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

}
