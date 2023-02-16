package com.solvd.airport.dao.impl;

import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.dao.GenericDao;
import com.solvd.airport.model.Airport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO implements GenericDao<Airport> {

    private IConnectionPool connectionPool;

    public AirportDAO(IConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }
    @Override
    public void addEntity(Airport airport) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql= "INSERT INTO Airport (idAirport, name, location) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, airport.getIdAirport());
            preparedStatement.setString(2, airport.getName());
            preparedStatement.setString(3, airport.getLocation());
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
    public Airport getEntityById(int idAirport) {
        Connection connection = connectionPool.getConnection();
        Airport airport = null;

        try {
            String sql = "SELECT * FROM Airport WHERE idAirport = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idAirport);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            airport = new Airport(result.getInt("idAirport"),
                    result.getString("name"), result.getString("location"));
        } catch(SQLException ex) {

        } finally {
            connectionPool.releaseConnection(connection);
        }
        return airport;
    }

    @Override
    public List<Airport> getAll() {
        List<Airport> airportsList = new ArrayList<>();
        String sql = "SELECT * FROM Airport";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Airport airport = new Airport();
                airport.setIdAirport(resultSet.getInt("idAirport"));
                airport.setName(resultSet.getString("name"));
                airportsList.add(airport);
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
        return airportsList;
    }

    @Override
    public void updateEntity(Airport airport) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Airport SET location = ? WHERE idAirport = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, airport.getLocation());
            preparedStatement.setInt(2, airport.getIdAirport());
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
    public void deleteEntity(Airport airport) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Airport WHERE idAirport = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, airport.getIdAirport());
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
