package db2024;

import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;

public final class App {

    public static void main(String[] args) throws Throwable {
        var frame = new JFrame();
        var size = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) Math.round(size.getWidth() / 2), (int) Math.round(size.getHeight() / 2));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        var res_set = Queries.visualizzaTratteTrafficate("2024-01-02", "2024-01-03");

        debugResultSet(res_set);
    }

    private static void debugResultSet(ResultSet set) throws SQLException {
        final int col = set.getMetaData().getColumnCount();
        while (set.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.print(set.getObject(i)+ "\t");
            }
            System.out.println();
        }
    }
}
