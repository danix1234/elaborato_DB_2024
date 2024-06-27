package db2024;

import db2024.DBConnection;

import java.awt.Toolkit;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFrame;

public final class App {

    public static void main(String[] args) throws Throwable {
        var frame = new JFrame();
        var size = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) Math.round(size.getWidth() / 2), (int) Math.round(size.getHeight() / 2));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        var res_set = DBConnection.executeQuery(Queries.VISUALIZZA_PROFITTO_MEDIO, "LIMF", "LIPK", "LIPK", "LIMF","2024-01-01", "2024-01-02");

        System.out.println(res_set.getMetaData().getColumnCount());
        while(res_set.next()){
            System.out.println(res_set.getObject(1));
        }
    }
}
