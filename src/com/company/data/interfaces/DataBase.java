package com.company.data.interfaces;
import java.sql.Connection;
import java.sql.SQLException;

public interface DataBase {
    Connection getConnection() throws SQLException, ClassNotFoundException;
}