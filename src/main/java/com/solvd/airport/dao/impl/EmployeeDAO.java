package com.solvd.airport.dao.impl;

import com.solvd.airport.connection.IConnectionPool;
import com.solvd.airport.dao.GenericDao;
import com.solvd.airport.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements GenericDao<Employee> {

    private IConnectionPool connectionPool;

    @Override
    public void addEntity(Employee employee) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql= "INSERT INTO employee (idEmployee, Position, Name, airplaneId) VALUES (?, ?, ?,?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getIdEmployee());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setInt(3, employee.getAirplaneId());
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
    public Employee getEntityById(int idEmployee) {
        Connection connection = connectionPool.getConnection();
        Employee employee = null;

        try {
            String sql = "SELECT * FROM employee WHERE idEmployee = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idEmployee);
            ResultSet result = preparedStatement.executeQuery();
            result.next();
            employee = new Employee(result.getInt("idEmployee"),
                    result.getString("Position"), result.getString("Name"),
                    result.getInt("airplaneId"));
        } catch(SQLException ex) {

        } finally {
            connectionPool.releaseConnection(connection);
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeesList = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        Statement statement = null;
        Connection connection = connectionPool.getConnection();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setIdEmployee(resultSet.getInt("idEmployee"));
                employee.setName(resultSet.getString("Name"));
                employeesList.add(employee);
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
        return employeesList;
    }

    @Override
    public void updateEntity(Employee employee) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE employee SET Position = ? WHERE idEmployee = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getPosition());
            preparedStatement.setInt(2, employee.getIdEmployee());
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
    public void deleteEntity(Employee employee) {
        Connection connection = connectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM employee WHERE idEmployee = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getIdEmployee());
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
