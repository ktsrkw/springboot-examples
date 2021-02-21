package com.wt.mapper;

import com.wt.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //想要实现这样的select语句:
    //select student.id,student.name,teacher.name
    //from student,teacher
    //where student.tid=teacher.id
    //如果直接执行是查不出的，必须再=在配置文件中“模拟”联表查询或嵌套查询

    //获得所有学生，模拟嵌套查询
    List<Student> getAllStudents01();
    //获得所有学生，模拟联表查询
    List<Student> getAllStudents02();
}
