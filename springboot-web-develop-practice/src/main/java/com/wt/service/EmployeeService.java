package com.wt.service;

import com.wt.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    //得到所有员工信息
    List<Employee> getAllEmployees();

    //根据id得到员工信息
    Employee getEmployeeById(int id);

    //增加一个员工
    int addAnEmployee(Employee employee);

    //根据id删除一个员工
    int deleteAnEmployeeById(int id);

    //修改一个员工的信息
    int updateAnEmployee(Employee employee);
}
