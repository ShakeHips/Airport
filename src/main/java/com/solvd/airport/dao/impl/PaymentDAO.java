package com.solvd.airport.dao.impl;

import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.dao.GenericDao;
import com.solvd.airport.model.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO implements GenericDao<Payment> {

    private IConnectionPool connectionPool;

    @Override
    public void addEntity(Payment payment) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql= "INSERT INTO Payment (idPayment, ZIPcode, paymenttypeId, bookingId) VALUES (?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, payment.getIdPayment());
            preparedStatement.setString(2, payment.getZIPcode());
            preparedStatement.setInt(3, payment.getPaymenttypeId());
            preparedStatement.setInt(3, payment.getBookingId());
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
    public Payment getEntityById(int idPayment) {
        Connection connection = connectionPool.getConnection();
        Payment payment = null;

        try {
            String sql = "SELECT * FROM Payment WHERE idPayment = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idPayment);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            payment = new Payment(result.getInt("idPayment"),
                    result.getString("ZIPcode"), result.getInt("paymenttypeId"),
                    result.getInt("bookingId"));
        } catch(SQLException ex) {

        } finally {
            connectionPool.releaseConnection(connection);
        }
        return payment;
    }

    @Override
    public List<Payment> getAll() {
        List<Payment> paymentsList = new ArrayList<>();
        String sql = "SELECT * FROM Payment";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setIdPayment(resultSet.getInt("idPayment"));
                payment.setZIPcode(resultSet.getString("ZIPcode"));
                paymentsList.add(payment);
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
        return paymentsList;
    }

    @Override
    public void updateEntity(Payment payment) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Payment SET ZIPcode = ? WHERE idPayment = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, payment.getZIPcode());
            preparedStatement.setInt(2, payment.getIdPayment());
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
    public void deleteEntity(Payment payment) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Payment WHERE idPayment = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, payment.getIdPayment());
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
