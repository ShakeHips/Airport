package com.solvd.airport.dao.impl;

import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.dao.GenericDao;
import com.solvd.airport.model.Luggage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LuggageDAO implements GenericDao<Luggage> {
    private IConnectionPool connectionPool;

    public LuggageDAO(IConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }


    @Override
    public void addEntity(Luggage luggage) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql= "INSERT INTO Luggage (idLuggage, weight, type) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, luggage.getIdLuggage());
            preparedStatement.setString(2, luggage.getWeight());
            preparedStatement.setString(3, luggage.getType());
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
    public Luggage getEntityById(int id_Luggage) {
        Connection connection = connectionPool.getConnection();
        Luggage luggage = null;

        try {
            String sql = "SELECT * FROM Luggage WHERE idLuggage = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id_Luggage);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            luggage = new Luggage(result.getInt("idLuggage"),
                    result.getString("Weight"),
                    result.getString("Type"));
        } catch(SQLException ex) {

        } finally {
            connectionPool.releaseConnection(connection);
        }
        return luggage;
    }
    @Override
    public List<Luggage> getAll() {
        List<Luggage> luggagesList = new ArrayList<>();
        String sql = "SELECT * FROM Luggage";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Luggage luggage= new Luggage();
                luggage.setIdLuggage(resultSet.getInt("idLuggage"));
                luggage.setWeight(resultSet.getString("Weight"));
                luggage.setType(resultSet.getString("Type"));
                luggagesList.add(luggage);
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
        return luggagesList;
    }

    @Override
    public void updateEntity(Luggage luggage) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Luggage SET weight = ?, type = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, luggage.getWeight());
            preparedStatement.setString(2, luggage.getType());
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
    public void deleteEntity(Luggage luggage) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Luggage WHERE idLuggage = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
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
