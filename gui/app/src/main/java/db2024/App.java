package db2024;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class App {

    public static void main(String[] args) throws Throwable {
        var loginFrame = new TopLevel("login", 400, 300);
        var mainFrame = new TopLevel("Compagnia aerea");
        loginFrame.show();
        Thread.sleep(10000);
        loginFrame.close();
        mainFrame.show();

        System.out.println(Queries.controllaAccountEsiste("Gaia.Bianchi@outlook.com", "eczfdawf1"));
        debugResultSet(Queries.ricercaPostiDisponibili(2));
    }

    public static void debugResultSet(ResultSet set) throws SQLException {
        final int col = set.getMetaData().getColumnCount();
        while (set.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.print(set.getObject(i) + "\t");
            }
            System.out.println();
        }
    }
}
