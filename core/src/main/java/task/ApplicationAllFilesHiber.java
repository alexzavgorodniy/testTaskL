package task;

import java.io.File;
import java.util.List;
import task.dao.impl.DaoFactoryHiberImpl;
import task.dao.impl.FilesDaoHibernate;
import task.model.Line;
import task.model.ReadFile;
import task.service.FileSearching;

public class ApplicationAllFilesHiber {

    public static void main(String[] args) {
        FileSearching fileSearching = new FileSearching();
        fileSearching.processFilesFromFolder(new File("./web/src/main/java/task/config"));
        ReadFile fileName = new FilesDaoHibernate().findOneByFileId(1);

        System.out.println(fileName);

        new DaoFactoryHiberImpl().closeConnection();
    }

}
