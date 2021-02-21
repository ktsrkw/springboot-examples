package com.wt;

import com.wt.mapper.DepartmentMapper;
import com.wt.mapper.EmployeeMapper;
import com.wt.pojo.Department;
import com.wt.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpringbootWebDevelopPracticeApplicationTests {


//    @Autowired
//    DataSource dataSource;

//    @Autowired
//    private DepartmentMapper departmentMapper;

//    @Autowired
//    private EmployeeMapper employeeMapper;
//
//    Employee employee = new Employee("gg",
//            "gktsrkwg@yeah.net",
//            1,
//            new Department(101,"市场部"),
//            new Date(1996,2,21));

    Employee employee1 = new Employee("hh",
            "hktsrkwh@yeah.net",
            0,
            new Department(102,"技术部"),
            new Date(1983,3,21));

    @Test
    public void insertTest(){
        System.out.println(employee1.getBirth().toString());
    }

//    @Test
//    public void evTest(){
//        List<Department> departments = departmentMapper.getAllDepartments();
//        for(Department department : departments){
//            System.out.println(department);
//        }
//    }


    @Test
    void contextLoads() {
    }

//    @Test
//    public void testMybatis() throws SQLException {
//        System.out.printf(String.valueOf(dataSource.getClass()));
//        System.out.println(dataSource.getConnection());
//    }

}
