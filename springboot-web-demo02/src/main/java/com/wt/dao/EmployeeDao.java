package com.wt.dao;

import com.wt.pojo.Department;
import com.wt.pojo.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    static{
        employees = new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"aa","ktsrkwa@yeah.net",0,new Department(101,"市场部"),new Date()));
        employees.put(1002,new Employee(1002,"bb","ktsrkwb@yeah.net",1,new Department(102,"技术部"),new Date()));
        employees.put(1003,new Employee(1003,"cc","ktsrkwc@yeah.net",0,new Department(102,"技术部"),new Date()));
        employees.put(1004,new Employee(1004,"dd","ktsrkwd@yeah.net",1,new Department(103,"人力部"),new Date()));
        employees.put(1005,new Employee(1005,"ee","ktsrkwe@yeah.net",0,new Department(104,"后勤部"),new Date()));
    }

    //主键自增
    public static Integer initId =1005;

    //增加一个员工
    public void addAEmployee(Employee employee){
        initId++;
        employees.put(initId,employee);
    }

    //移除一个员工
    public void removeAEmployeeById(Integer id){
        employees.remove(id);
    }

    //通过id查询一个员工
    public Employee selectAEmployeeById(Integer id){
        return employees.get(id);
    }

    //查询全部员工
    public Collection<Employee> selectAllEmployees(){
        return employees.values();
    }

}
