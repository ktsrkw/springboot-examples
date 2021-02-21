package com.wt.pojo;

public class Teacher {
    private int tid;
    private String name;

    public Teacher(int tid, String name) {
        this.tid = tid;
        this.name = name;
    }

    public Teacher() {

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
}
