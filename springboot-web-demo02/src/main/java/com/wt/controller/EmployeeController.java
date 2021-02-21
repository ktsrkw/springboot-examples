package com.wt.controller;

import com.wt.dao.DepartmentDao;
import com.wt.dao.EmployeeDao;
import com.wt.pojo.Department;
import com.wt.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    //Controller层调service层，这里简化直接调dao层了
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;


    @RequestMapping("/employee")
    public String toForm(Model model){
        Collection<Employee> employees = employeeDao.selectAllEmployees();
        model.addAttribute("employees",employees);
        return "form";
    }

    @GetMapping("/addEmployee")//form页跳转到addEmployee页，get请求
    public String toAddEmployee(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "addEmployee";
    }

    @PostMapping("/addEmployee")//addEmployee页提交表单，post请求
    public String addEmployee(Employee employee){//前台传来的参数自动地被封装成一个对象，前提是前台的那么属性要与对象中的属性名一致
        employeeDao.addAEmployee(employee);
        return "redirect:/employee";
    }

    //去修改页面
    @GetMapping("/updateEmployee/{id}")//restful风格
    public String toUpdatePage(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeDao.selectAEmployeeById(id);
        model.addAttribute("employee",employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        return "updateEmployee";
    }

    //提交修改
    @PostMapping("/updateEmployee")
    public String updateEmployee(Employee employee){
        employeeDao.addAEmployee(employee);
        return "redirect:/employee";
    }

    //删除
    @GetMapping("/deleteEmployee/{id}")
    public String deleteAEmployee(@PathVariable("id")int id){
        employeeDao.removeAEmployeeById(id);
        return "redirect:/employee";
    }
}
