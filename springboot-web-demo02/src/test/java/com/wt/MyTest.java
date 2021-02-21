package com.wt;

import com.wt.dao.DepartmentDao;
import com.wt.pojo.Department;
import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    void departmentDaoBeanTest(){
        DepartmentDao departmentDao = new DepartmentDao();
        Department department = departmentDao.getDepartmentById(101);
        System.out.println(department);
    }
}
