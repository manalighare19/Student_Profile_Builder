
/*
 ************************ Assignment #InClass 03 *******************************************
 *********************** File Name- Student.java *************************************
 ************************ Full Name- 1. Manali Ghare 2. Anup Deshpande (Group 19) ***********

 */



package com.example.manalighare.inclass03;

import java.io.Serializable;

public class Student implements Serializable{
    private String fname;
    private String lname;
    private String S_ID;
    private String dept;
    private String image_name;


    public Student(String fname, String lname, String s_ID, String dept, String image_name) {
        this.fname = fname;
        this.lname = lname;
        S_ID = s_ID;
        this.dept = dept;
        this.image_name = image_name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", S_ID=" + S_ID +
                ", dept='" + dept + '\'' +
                ", image_name='" + image_name + '\'' +
                '}';
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getS_ID() {
        return S_ID;
    }

    public void setS_ID(String s_ID) {
        S_ID = s_ID;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }
}
