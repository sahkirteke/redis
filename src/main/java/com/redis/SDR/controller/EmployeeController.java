package com.redis.SDR.controller;

import com.redis.SDR.model.Employee;
import com.redis.SDR.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody  Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public Iterable<Employee> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/con")
    public List<Employee> findByEmployeeName(@RequestParam(required = false) String name) {
        return employeeService.findByEmployeeName(name);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id,@RequestBody Employee employee) {
        return employeeService.update(id,employee);
    }
}
