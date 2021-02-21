package com.wt.service;

import com.wt.mapper.EmployeeMapper;
import com.wt.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //service层调dao层
    @Autowired
    EmployeeMapper employeeMapper;

    //得到所有员工信息
    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.getAllEmployees();
    }

    //根据id得到员工信息
    @Override
    public Employee getEmployeeById(@Param("id") int id) {
        return employeeMapper.getEmployeeById(id);
    }

    //增加一个员工
    @Override
    public int addAnEmployee(Employee employee) {
        return employeeMapper.addAnEmployee(employee);
    }

    //根据id删除一个员工
    @Override
    public int deleteAnEmployeeById(int id) {
        return employeeMapper.deleteAnEmployeeById(id);
    }

    //修改一个员工的信息
    @Override
    public int updateAnEmployee(Employee employee) {
        return employeeMapper.updateAnEmployee(employee);
    }
}
