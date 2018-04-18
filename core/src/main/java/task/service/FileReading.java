package task.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import task.model.Line;

class FileReading {

    List<Line> openFile(String path, Integer id) {
        String line;
        List<Line> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null) {
                Line lineOfText = new Line();
                lineOfText.setTitle(line);
                lineOfText.setReadfileId(id);
                lineOfText = new LineStatistics().lineStatistics(lineOfText);
                lines.add(lineOfText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

}
