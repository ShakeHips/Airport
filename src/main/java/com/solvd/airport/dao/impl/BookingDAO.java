package com.solvd.airport.dao.impl;

import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.dao.GenericDao;
import com.solvd.airport.model.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO implements GenericDao<Booking> {

    private IConnectionPool connectionPool;

    public BookingDAO(IConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }


    @Override
    public void addEntity(Booking booking) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql= "INSERT INTO booking (idBooking, seat, price, airportId) VALUES (?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, booking.getAirportId());
            preparedStatement.setInt(2, booking.getIdBooking());
            preparedStatement.setDouble(3,booking.getPrice());
            preparedStatement.setDouble(4,booking.getSeat());
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
    public Booking getEntityById(int idBooking) {
        Connection connection = connectionPool.getConnection();
        Booking booking = null;

        try {
            String sql = "SELECT * FROM booking WHERE idBooking = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idBooking);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            booking = new Booking(result.getInt("idBooking"),
                    result.getInt("seat"), result.getDouble("Price"),
                    result.getInt("airportId"));
        } catch(SQLException ex) {

        } finally {
            connectionPool.releaseConnection(connection);
        }
        return booking;
    }

    @Override
    public List<Booking> getAll() {
        List<Booking> bookingsList = new ArrayList<>();
        String sql = "SELECT * FROM Booking";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setIdBooking(resultSet.getInt("idBooking"));
                booking.setSeat(resultSet.getInt("seat"));
                booking.setPrice(resultSet.getDouble("Price"));
                booking.setAirportId(resultSet.getInt("airportId"));
                bookingsList.add(booking);
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
        return bookingsList;
    }

    @Override
    public void updateEntity(Booking booking) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE Booking SET seat = ?, price = ?, airportId = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, booking.getSeat());
            preparedStatement.setDouble(2, booking.getPrice());
            preparedStatement.setInt(2, booking.getAirportId());
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
    public void deleteEntity(Booking booking) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM Booking WHERE idBooking = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, booking.getIdBooking());
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
