package com.redis.SDR.service;

import com.redis.SDR.model.Employee;
import com.redis.SDR.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;


    public Employee saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public Iterable<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findByEmployeeName(String employeeName) {
        return employeeRepository.findByNameContaining(employeeName);
    }

    public Employee update(Long id,Employee employee) {
        Employee oldEmployee = employeeRepository.findById(id).get();

        oldEmployee.setAge(employee.getAge());
        oldEmployee.setName(employee.getName());
        oldEmployee.setSurname(employee.getSurname());
        return employeeRepository.save(oldEmployee);
    }
}
