package task.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import task.dao.impl.FilesDaoHibernate;
import task.dao.impl.LineDaoHibernate;
import task.model.Line;
import task.model.ReadFile;

public class FileSearching {

    public void processFilesFromFolder(File folder) {
        File[] folderEntries = folder.listFiles();
        for (File entry : Objects.requireNonNull(folderEntries)) {
            List<ReadFile> readFileList = new ArrayList<>();
            if (entry.isDirectory()) {
                processFilesFromFolder(entry);
            } else {
                String absolutePath = entry.getAbsolutePath();
                ReadFile readFile = new ReadFile(entry.getName());
                List<Line> lines = new FileReading().openFile(absolutePath, readFile.getId());
                new LineDaoHibernate().addAllEntities(lines);
                readFile.setPath(absolutePath);
                readFile.setLineCount(lines.size());
                readFileList.add(readFile);
            }
            new FilesDaoHibernate().addAllEntities(readFileList);
        }
    }
}
