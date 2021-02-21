package com.wt.service;

import com.wt.pojo.Department;

import java.util.List;

public interface DepartmentService {
    //得到所有部门的信息
    List<Department> getAllDepartments();

    //根据id得到部门的信息
    Department getDepartmentById(int id);
}
