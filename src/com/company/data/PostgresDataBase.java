package com.company.data;
import com.company.data.interfaces.DataBase;
import java.sql.*;
public class PostgresDataBase implements DataBase {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "12345");

            return con;
        } catch (Exception exceptioninprogram) {
            System.out.println(exceptioninprogram);
            throw exceptioninprogram;
        }
    }
}