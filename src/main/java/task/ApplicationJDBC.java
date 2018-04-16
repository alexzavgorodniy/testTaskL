package task;

import task.service.WorkOverJDBC;

public class ApplicationJDBC {

    public static void main(String[] args) {
        WorkOverJDBC workOverJdbc = new WorkOverJDBC();
        workOverJdbc.dbConnection();
    }

}
