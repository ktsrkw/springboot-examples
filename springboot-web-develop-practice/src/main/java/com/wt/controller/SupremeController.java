package com.wt.controller;

import com.wt.pojo.Department;
import com.wt.pojo.Employee;
import com.wt.service.DepartmentService;
import com.wt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Controller
public class SupremeController {
    @Autowired
    @Qualifier("departmentServiceImpl")
    DepartmentService departmentService;

    @Autowired
    @Qualifier("employeeServiceImpl")
    EmployeeService employeeService;

    //接受登录请求处理提交的表单
    @GetMapping("/user/login")
    public String signIn(String username, String password, Model model){
        //如果用户名不为空且密码为111111就让其登录进入dashboard页
        if(!StringUtils.isEmpty(username) && password.equals("111111")){
            return "redirect:/dashboard";
        }else{
            model.addAttribute("errorMsg01","密码错误");
            return "signin";
        }
    }

    //去dashboard页
    @GetMapping("/dashboard")
    public String toDashboard(){
        return "dashboard";
    }

    //去员工管理页，转发时从数据库中拿到employees供form页面使用
    //一定要转发，重定向的话跳转后model中的数据跳转后的页面拿不到
    @GetMapping("/employee")
    public String toEmployee(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
        return "form";
    }
      //重定向model取数据测试
//    @GetMapping("/form")
//    public String toForm(){
//        return "form";
//    }

    //到添加员工的页面
    @GetMapping("/addEmployee")
    public String toAddEmployee(Model model){
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("departments",departments);
        return "addEmployee";
    }

    //处理提交添加的员工
    @PostMapping("/addEmployee")
    public String addEmployee(Employee employee){
        employeeService.addAnEmployee(employee);
        return "redirect:/employee";
    }

    //处理删除员工
    @GetMapping("/deleteEmployee/{id}")
    public String deleteAnEmployee(@PathVariable int id){
        employeeService.deleteAnEmployeeById(id);
        return "redirect:/employee";
    }

    //处理跳转至修改员工页面请求
    @GetMapping("/updateEmployee/{id}")
    public String toUpdateEmployee(@PathVariable int id,Model model){
        Employee employee = employeeService.getEmployeeById(id);
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("employee",employee);
        model.addAttribute("departments",departments);
        return "updateEmployee";
    }

    //处理修改员工信息请求
    @PostMapping("/updateEmployee")
    public String updateEmployee(Employee employee){
        //拿到的自动封装的对象，再调service层
        employeeService.updateAnEmployee(employee);
        return "redirect:employee";
    }
}








