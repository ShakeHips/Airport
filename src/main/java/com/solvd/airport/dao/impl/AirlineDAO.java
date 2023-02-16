package com.solvd.airport.dao.impl;

import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.dao.GenericDao;
import com.solvd.airport.model.Airline;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirlineDAO implements GenericDao<Airline> {

    private IConnectionPool connectionPool;

    public AirlineDAO(IConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }

    @Override
    public void addEntity(Airline airline) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql= "INSERT INTO Airline (idAirline, name, airportId) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, airline.getIdAirline());
            preparedStatement.setString(2, airline.getName());
            preparedStatement.setInt(3, airline.getAirportId());
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
    public Airline getEntityById(int idAirline) {
        Connection connection = connectionPool.getConnection();
        Airline airline = null;

        try {
            String sql = "SELECT * FROM Airline WHERE idAirline = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idAirline);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            airline = new Airline(result.getInt("idAirline"),
                    result.getString("name"), result.getInt("airportId"));
        } catch(SQLException ex) {

        } finally {
            connectionPool.releaseConnection(connection);
        }
        return airline;
    }

    @Override
    public List<Airline> getAll() {
        List<Airline> airlinesList = new ArrayList<>();
        String sql = "SELECT * FROM Airline";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Airline airline = new Airline();
                airline.setIdAirline(resultSet.getInt("idAirline"));
                airline.setName(resultSet.getString("name"));
                airlinesList.add(airline);
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
        return airlinesList;
    }

    @Override
    public void updateEntity(Airline airline) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Airline SET name = ? WHERE idAirline = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, airline.getName());
            preparedStatement.setInt(2, airline.getIdAirline());
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
    public void deleteEntity(Airline airline) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Airline WHERE idAirline = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, airline.getIdAirline());
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
