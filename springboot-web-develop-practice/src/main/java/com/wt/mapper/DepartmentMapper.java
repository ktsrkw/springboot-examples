package com.wt.mapper;

import com.wt.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {
    //得到所有部门的信息
    List<Department> getAllDepartments();

    //根据id得到部门的信息
    Department getDepartmentById(int id);
}
