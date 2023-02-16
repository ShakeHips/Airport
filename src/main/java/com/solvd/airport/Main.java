package com.solvd.airport;

import com.solvd.airport.connection.DbProperties;
import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.connection.ConnectionPool;
import com.solvd.airport.dao.impl.AirportDAO;
import com.solvd.airport.model.Airport;
//import com.solvd.airport.parser.AirplaneHandler;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception{

        try {
            DbProperties.loadProperties();
            IConnectionPool connectionPool = ConnectionPool.getInstance(DbProperties.getHost(), DbProperties.getName(), DbProperties.getPassword());

            AirportDAO airportDao = new AirportDAO(connectionPool);
            Airport airport = new Airport(15, "Freddie","Mercury");
            airportDao.deleteEntity(airport);
        } catch (SQLException e){

        }
    }
}