

package org.example.multithreadingjavapractive.Utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SqlDatabaseManager{
    private static Connection connection = null;
    private static final String path = "jdbc:sqlite:src/main/resources/org/example/multithreadingjavapractive/utils/dictionary.db";

    public static Connection getConnection(){
        if(connection == null){
            try{
                connection = DriverManager.getConnection(path);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
