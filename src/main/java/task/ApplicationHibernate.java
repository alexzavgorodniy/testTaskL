package task;

import task.service.WorkOverHibernate;

public class ApplicationHibernate {

    public static void main(String[] args) {
        WorkOverHibernate workOverHibernate = new WorkOverHibernate();
        workOverHibernate.dbConnection();
    }
}
