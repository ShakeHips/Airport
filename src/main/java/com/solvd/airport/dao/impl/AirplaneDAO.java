package com.solvd.airport.dao.impl;

import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.dao.GenericDao;
import com.solvd.airport.model.Airplane;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirplaneDAO implements GenericDao<Airplane> {

    private IConnectionPool connectionPool;

    @Override
    public void addEntity(Airplane airplane) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql= "INSERT INTO Airplane (idAirplane, capacity, airline) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, airplane.getIdAirplane());
            preparedStatement.setInt(2, airplane.getCapacity());
            preparedStatement.setString(3, airplane.getAirline());
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
    public Airplane getEntityById(int idAirplane) {
        Connection connection = connectionPool.getConnection();
        Airplane airplane = null;

        try {
            String sql = "SELECT * FROM Airplane WHERE idAirplane = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idAirplane);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            airplane = new Airplane(result.getInt("idairport"),
                    result.getInt("capacity"), result.getString("airline"));
        } catch(SQLException ex) {

        } finally {
            connectionPool.releaseConnection(connection);
        }
        return airplane;
    }


    @Override
    public List<Airplane> getAll() {
        List<Airplane> airplanesList = new ArrayList<>();
        String sql = "SELECT * FROM Airplane";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Airplane airplane = new Airplane();
                airplane.setIdAirplane(resultSet.getInt("idAirplane"));
                airplane.setCapacity(resultSet.getInt("capacity"));
                airplanesList.add(airplane);
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
        return airplanesList;
    }

    @Override
    public void updateEntity(Airplane airplane) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Airplane SET capacity = ? WHERE idAirplane = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, airplane.getCapacity());
            preparedStatement.setInt(2, airplane.getIdAirplane());
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
    public void deleteEntity(Airplane airplane) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Airplane WHERE idAirplane = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, airplane.getIdAirplane());
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
