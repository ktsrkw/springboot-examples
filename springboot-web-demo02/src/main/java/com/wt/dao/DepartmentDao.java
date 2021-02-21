package com.wt.dao;

import com.wt.pojo.Department;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//模拟数据库中的数据
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;
    static{
        departments = new HashMap<Integer, Department>();
        departments.put(101,new Department(101,"市场部"));
        departments.put(102,new Department(102,"技术部"));
        departments.put(103,new Department(103,"人力部"));
        departments.put(104,new Department(104,"后勤部"));
    }

    //得到所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }

}
