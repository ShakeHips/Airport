package com.solvd.airport.dao.impl;

import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.dao.GenericDao;
import com.solvd.airport.model.Passenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO implements GenericDao<Passenger> {

    private IConnectionPool connectionPool;


    public PassengerDAO(IConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    @Override
    public void addEntity(Passenger passenger) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Passenger (idPassenger, name, bookingId, luggageId, age) VALUES(?,?,?,?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, passenger.getAge());
            preparedStatement.setString(2, passenger.getName());
            preparedStatement.setInt(3, passenger.getIdPassenger());
            preparedStatement.setInt(4, passenger.getLuggageId());
            preparedStatement.setInt(5, passenger.getBookingId());
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
    public Passenger getEntityById(int idPassenger) {
        Connection connection = connectionPool.getConnection();
        Passenger passenger = null;

        try {
            String sql = "SELECT * FROM Passenger WHERE idPassenger = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idPassenger);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            passenger = new Passenger(result.getInt("idPassenger"),
                    result.getString("name"), result.getInt("bookingId"),
                    result.getInt("luggageId"),
                    result.getInt("age"));
        } catch(SQLException ex) {

        } finally {
            connectionPool.releaseConnection(connection);
        }
        return passenger;
    }

    @Override
    public List<Passenger> getAll() {
        List<Passenger> passengersList = new ArrayList<>();
        String sql = "SELECT * FROM Passenger";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Passenger passenger = new Passenger();
                passenger.setIdPassenger(resultSet.getInt("idPassenger"));
                passenger.setName(resultSet.getString("name"));
                passenger.setBookingId(resultSet.getInt("bookingId"));
                passenger.setLuggageId(resultSet.getInt("luggageId"));
                passenger.setAge(resultSet.getInt("Age"));
                passengersList.add(passenger);
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
        return passengersList;
    }

    @Override
    public void updateEntity(Passenger passenger) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Passenger SET name = ? WHERE idPassenger = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setInt(2, passenger.getIdPassenger());
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
    public void deleteEntity(Passenger passenger) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Passenger WHERE idPassenger = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, passenger.getIdPassenger());
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
