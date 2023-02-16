package com.solvd.airport.service.implementation;

import com.solvd.airport.dao.IEmployeeDao;
import com.solvd.airport.model.Employee;
import com.solvd.airport.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeServiceImpl employeeServiceImpl;

    EmployeeServiceImpl(){
        employeeServiceImpl = new EmployeeServiceImpl();
    }
    @Override
    public boolean create(Employee element) {
        return employeeServiceImpl.create(element);
    }

    @Override
    public Employee get(Integer id) {
        return employeeServiceImpl.get(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeServiceImpl.getAll();
    }

    @Override
    public void update(Employee element) {
        employeeServiceImpl.update(element);
    }

    @Override
    public boolean delete(Integer id) {
        return employeeServiceImpl.delete(id);
    }
}
