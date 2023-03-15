package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.controller.Student;

public interface ServiceStudent {
	
	public int insert(Student student);
	public String delete(int roll_no);
	public String Create();
    List<Student> getall();
    public int UPDATE(Student student,int id);
    Student getsingle(int id);
}
