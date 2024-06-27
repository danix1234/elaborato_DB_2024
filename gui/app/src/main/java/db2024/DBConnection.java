package db2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class DBConnection {
    private static final Connection SINGLETON = initConnection();

    public static final Connection getConnection() {
        if (SINGLETON == null) {
            throw new IllegalStateException("connection not initliazed yet");
        }
        return SINGLETON;
    }

    private static final Connection initConnection() {
        List<String> lines;
        Connection res;
        try {
            lines = Files.readAllLines(Paths.get(System.getProperty("user.home") + "/.compagnia_aerea"));
        } catch (IOException e) {
            throw new IllegalStateException("file '.compagnia_aerea' wasn't found in the home directory");
        }
        try {
            res = DriverManager.getConnection("jdbc:mysql://localhost:3306/compagnia_aerea", lines.get(0), lines.get(1));
        } catch (Exception e) {
            throw new IllegalStateException("couldn't initialize connection");
        }
        return res;
    }
}
