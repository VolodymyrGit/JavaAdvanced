package com.db;

import com.db.DataHandler;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataHandler dataHandler = new DataHandler();
        dataHandler.checkTable("task");
    }
}
