package com.wt;

import com.wt.dao.DepartmentDao;
import com.wt.dao.EmployeeDao;
import com.wt.pojo.Department;
import com.wt.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootWebDemo02ApplicationTests {

//    @Autowired
//    DepartmentDao departmentDao;

    @Test
    void departmentDaoBeanTest(){
        DepartmentDao departmentDao = new DepartmentDao();
        Department department = departmentDao.getDepartmentById(101);
        System.out.println(department);
    }

}
