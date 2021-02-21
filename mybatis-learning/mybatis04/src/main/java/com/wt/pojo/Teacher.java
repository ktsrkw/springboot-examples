package com.wt.pojo;

import java.util.List;

public class Teacher {
    private int tid;
    private String name;
    private List<Student> students;

    public Teacher() {

    }

    public Teacher(int tid, String name, List<Student> students) {
        this.tid = tid;
        this.name = name;
        this.students = students;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
