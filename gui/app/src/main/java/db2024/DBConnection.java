package db2024;

import java.sql.Statement;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
        String username = "";
        String password = "";
        try {
            lines = Files.readAllLines(Paths.get(System.getProperty("user.home") + "/.compagnia_aerea"));
        } catch (IOException e) {
            throw new IllegalStateException("file '.compagnia_aerea' wasn't found in the home directory");
        }
        if (lines.size() > 0){
            username = lines.get(0);
        }
        if (lines.size() > 1){
            password = lines.get(1);
        }
        try {
            res = DriverManager.getConnection("jdbc:mysql://localhost:3306/compagnia_aerea", username, password);
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
    
    public static ResultSet executeQuery(String query){
        var stmt = emptyStmt();
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new IllegalStateException("could not execute query");
        }
    }
    
    public static ResultSet executeQuery(String query, Object...values){
        var prepsmtm = prepareStmt(query, values);
        try {
            return prepsmtm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException("could not execute prepared query");
        }
    }

    public static int executeUpdate(String query){
        var stmt = emptyStmt();
        try {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new IllegalStateException("could not execute query");
        }
    }
    
    public static int executeUpdate(String query, Object...values){
        var prepsmtm = prepareStmt(query, values);
        try {
            return prepsmtm.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException("could not execute prepared query");
        }
    }
}
