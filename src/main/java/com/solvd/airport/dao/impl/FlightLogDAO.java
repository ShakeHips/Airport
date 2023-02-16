package com.solvd.airport.dao.impl;

import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.dao.GenericDao;
import com.solvd.airport.model.FlightLog;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightLogDAO implements GenericDao<FlightLog> {

    private IConnectionPool connectionPool;

    @Override
    public void addEntity(FlightLog flight_log) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql= "INSERT INTO Flight_Log (idFlightlog, flightTime, WeatherInfo) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, flight_log.getIdFlightlog());
            preparedStatement.setString(2, flight_log.getFlightTime());
            preparedStatement.setString(3, flight_log.getWeatherInfo());
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
    public FlightLog getEntityById(int idFlight_Log) {
        Connection connection = connectionPool.getConnection();
        FlightLog flight_log = null;

        try {
            String sql = "SELECT * FROM Flightlog WHERE idFlightlog = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idFlight_Log);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            flight_log = new FlightLog(result.getInt("idFlightlog"),
                    result.getString("flightTime"), result.getString("WeatherInfo"));
        } catch(SQLException ex) {

        } finally {
            connectionPool.releaseConnection(connection);
        }
        return flight_log;
    }

    @Override
    public List<FlightLog> getAll() {
        List<FlightLog> flight_logsList = new ArrayList<>();
        String sql = "SELECT * FROM Flightlog";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                FlightLog flight_log = new FlightLog();
                flight_log.setIdFlightlog(resultSet.getInt("idFlightlog"));
                flight_log.setFlightTime(resultSet.getString("flightTime"));
                flight_logsList.add(flight_log);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
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
        return flight_logsList;
    }

    @Override
    public void updateEntity(FlightLog flight_log) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Flightlog SET flightTime = ? WHERE idFlightlog = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, flight_log.getFlightTime());
            preparedStatement.setInt(2, flight_log.getIdFlightlog());
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
    public void deleteEntity(FlightLog flight_log) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Flightlog WHERE idFlightlog = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, flight_log.getIdFlightlog());
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
