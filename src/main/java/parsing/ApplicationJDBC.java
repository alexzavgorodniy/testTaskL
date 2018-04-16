package parsing;

import parsing.service.JDBC;

public class ApplicationJDBC {

    public static void main(String[] args) {
        JDBC jdbc = new JDBC();
        jdbc.db();
    }

}
