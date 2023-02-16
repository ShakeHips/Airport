package com.solvd.airport.dao.impl;

import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.dao.GenericDao;
import com.solvd.airport.model.PassengerDetails;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerDetailsDAO implements GenericDao<PassengerDetails> {

    private IConnectionPool connectionPool;

    @Override
    public void addEntity(PassengerDetails passengerDetails) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql= "INSERT INTO passengerdetails (idpassengerdetails, Bonus, country, adress, Passenger_idPassenger) VALUES (?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, passengerDetails.getIdPassengerdetails());
            preparedStatement.setString(2, passengerDetails.getBonus());
            preparedStatement.setString(3, passengerDetails.getCountry());
            preparedStatement.setString(3, passengerDetails.getAdress());
            preparedStatement.setInt(3, passengerDetails.getPassengerId());
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
    public PassengerDetails getEntityById(int idpassengerdetails) {
        Connection connection = connectionPool.getConnection();
        PassengerDetails passengerDetails = null;

        try {
            String sql = "SELECT * FROM passengerdetails WHERE idPassengerdetails = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idpassengerdetails);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            passengerDetails = new PassengerDetails(result.getInt("idPassengerdetails"),
                    result.getString("Bonus"),
                    result.getString("country"), result.getString("adress"),
                    result.getInt("passengerId"));
        } catch(SQLException ex) {

        } finally {
            connectionPool.releaseConnection(connection);
        }
        return passengerDetails;
    }


    @Override
    public List<PassengerDetails> getAll() {
        List<PassengerDetails> passengerDetailsList = new ArrayList<>();
        String sql = "SELECT * FROM passengerdetails";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                PassengerDetails passengerDetails = new PassengerDetails();
                passengerDetails.setIdPassengerdetails(resultSet.getInt("idPassengerdetails"));
                passengerDetails.setBonus(resultSet.getString("Bonus"));
                passengerDetailsList.add(passengerDetails);
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
        return passengerDetailsList;
    }

    @Override
    public void updateEntity(PassengerDetails passengerDetails) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE PassengerDetails SET Bonus = ? WHERE idPassengerdetails = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passengerDetails.getBonus());
            preparedStatement.setInt(2, passengerDetails.getIdPassengerdetails());
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
    public void deleteEntity(PassengerDetails passengerDetails) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM passengerdetails WHERE idPassengerdetails = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, passengerDetails.getIdPassengerdetails());
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
