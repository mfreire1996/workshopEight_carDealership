package com.ps.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class DatabaseManager {
    private static final BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setUrl("jdbc:mysql://localhost:3306/CarDealership");
        dataSource.setUsername("root");
        dataSource.setPassword("Kk@6jJ/X-Y");

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}