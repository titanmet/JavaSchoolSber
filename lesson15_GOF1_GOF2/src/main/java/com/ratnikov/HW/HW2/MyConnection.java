package com.ratnikov.HW.HW2;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MyConnection {
    ResultSet databaseConnection() throws SQLException;
}
