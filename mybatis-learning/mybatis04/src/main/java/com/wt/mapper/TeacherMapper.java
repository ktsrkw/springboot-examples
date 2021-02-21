package com.wt.mapper;

import com.wt.pojo.Student;
import com.wt.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    //需求：根据老师的id查询出其所教的所有学生
    List<Student> getStudentsOfTeacherByTeacherId();

    //列出学生的同时列出老师
    Teacher getTeacherAndHerStudents(int tid);
}
