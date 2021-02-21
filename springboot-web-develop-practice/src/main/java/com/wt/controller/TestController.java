package com.wt.controller;

import com.wt.mapper.DepartmentMapper;
import com.wt.pojo.Department;
import com.wt.service.DepartmentService;
import com.wt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
//    @Autowired
//    DepartmentMapper departmentMapper;
//
//    @RequestMapping("/evtest")
//    public String evTest(){
//        List<Department> departments = departmentMapper.getAllDepartments();
//        return departments.toString();
//    }

    //Controller层调service层
    @Autowired
    @Qualifier("departmentServiceImpl")
    DepartmentService departmentService;

    @Autowired
    @Qualifier("employeeServiceImpl")
    EmployeeService employeeService;

    @RequestMapping("/evtest00/{did}")
    public String evTest00(@PathVariable int did){
        return departmentService.getDepartmentById(did).toString();
    }

    @RequestMapping("/evtest01/{eid}")
    public String evTest01(@PathVariable int eid){
        return employeeService.getEmployeeById(eid).toString();
    }
}
