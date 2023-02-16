package com.solvd.airport.connection;

import java.sql.Connection;

public interface IConnectionPool {
        Connection getConnection();
        boolean releaseConnection(Connection connection);
    }

