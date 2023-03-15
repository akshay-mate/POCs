package com.example.demo.controller;

public class Student {
	private int id;
	private String studentName;
	private int age;
	private String city;
	private String country;
	public int getId() {
		return id;
	}
	public String getStudentName() {
		return studentName;
	}
	public int getAge() {
		return age;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + ", age=" + age + ", city=" + city + ", country="
				+ country + "]";
	}
	
	
	
} 
