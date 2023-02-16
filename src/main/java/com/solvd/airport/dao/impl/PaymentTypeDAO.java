package com.solvd.airport.dao.impl;

import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.dao.GenericDao;
import com.solvd.airport.model.PaymentType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentTypeDAO implements GenericDao<PaymentType> {

    private IConnectionPool connectionPool;

    @Override
    public void addEntity(PaymentType paymentType) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql= "INSERT INTO PaymentType (idPaymentType, Paymentinfo, passengerdetailsId) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, paymentType.getIdPaymentType());
            preparedStatement.setString(2, paymentType.getPaymentinfo());
            preparedStatement.setInt(3, paymentType.getPassengerdetailsId());
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
    public PaymentType getEntityById(int idPaymentType) {
        Connection connection = connectionPool.getConnection();
        PaymentType paymentType = null;

        try {
            String sql = "SELECT * FROM PaymentType WHERE idPaymentType = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idPaymentType);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            paymentType = new PaymentType(result.getInt("idPaymentType"),
                    result.getString("Paymentinfo"), result.getInt("passengerdetailsId"));
        } catch(SQLException ex) {

        } finally {
            connectionPool.releaseConnection(connection);
        }
        return paymentType;
    }

    @Override
    public List<PaymentType> getAll() {
        List<PaymentType> paymentTypesList = new ArrayList<>();
        String sql = "SELECT * FROM PaymentType";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                PaymentType paymentType = new PaymentType();
                paymentType.setIdPaymentType(resultSet.getInt("idPaymentType"));
                paymentType.setPaymentinfo(resultSet.getString("Paymentinfo"));
                paymentTypesList.add(paymentType);
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
        return paymentTypesList;
    }

    @Override
    public void updateEntity(PaymentType paymentType) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE PaymentType SET Paymentinfo = ? WHERE idPaymentType = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, paymentType.getPaymentinfo());
            preparedStatement.setInt(2, paymentType.getIdPaymentType());
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
    public void deleteEntity(PaymentType paymentType) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM PaymentType WHERE idPaymentType = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, paymentType.getIdPaymentType());
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
