package com.wt.service;

import com.wt.mapper.DepartmentMapper;
import com.wt.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    //service层调dao层
    @Autowired
    DepartmentMapper departmentMapper;

    //得到所有部门的信息
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments();
    }

    //根据id得到部门的信息
    @Override
    public Department getDepartmentById(int id) {
        return departmentMapper.getDepartmentById(id);
    }
}
