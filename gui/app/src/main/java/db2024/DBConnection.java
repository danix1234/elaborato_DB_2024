package db2024;

import java.sql.Statement;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            res = DriverManager.getConnection("jdbc:mysql://localhost:3306/compagnia_aerea", lines.get(0),
                    lines.get(1));
        } catch (Exception e) {
            throw new IllegalStateException("couldn't initialize connection");
        }
        return res;
    }
    
    public static Statement emptyStmt(){
        try {
            return SINGLETON.createStatement();
        } catch (SQLException e) {
            throw new IllegalStateException("could not create empty statement");
        }
    }

    public static PreparedStatement prepareStmt(String query, Object... values) {
        PreparedStatement statement = null;
        try {
            statement = SINGLETON.prepareStatement(query);
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            return statement;
        } catch (Exception e) {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e1) {
                    throw new IllegalStateException("could not close statement");
                }
                throw new IllegalStateException("could not prepare statement");
            }
        }
        return statement;
    }
}
