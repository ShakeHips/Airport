package com.solvd.airport.dao.impl;

import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.dao.GenericDao;
import com.solvd.airport.model.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FlightDAO implements GenericDao<Flight> {

    private IConnectionPool connectionPool;


    @Override
    public void addEntity(Flight flight) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql= "INSERT INTO Flight (idFlight, Departure, Arrival, employeeId, flightlogId, " +
                "AirplaneId,airlineId,airportId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, flight.getIdFlight());
            preparedStatement.setString(2, flight.getDeparture());
            preparedStatement.setString(3,flight.getArrival());
            preparedStatement.setInt(3,flight.getEmployeeId());
            preparedStatement.setInt(3,flight.getFlightlogId());
            preparedStatement.setInt(3,flight.getAirplaneId());
            preparedStatement.setInt(3,flight.getAirlineId());
            preparedStatement.setInt(3,flight.getAirportId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }

    @Override
    public Flight getEntityById(int id) {
        return null;
    }

    @Override
    public List<Flight> getAll() {
        return null;
    }

    @Override
    public void updateEntity(Flight flight) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Flight SET Departure = ?, Arrival";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, flight.getDeparture());
            preparedStatement.setString(2, flight.getArrival());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }

    @Override
    public void deleteEntity(Flight flight) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Flight WHERE idFlight = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, flight.getIdFlight());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }
}
