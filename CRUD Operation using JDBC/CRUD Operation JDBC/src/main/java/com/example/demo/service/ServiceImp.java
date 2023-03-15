package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.controller.Student;

@Service
public class ServiceImp implements ServiceStudent {
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int insert(Student student) {
		String sql = "insert into Student(studentName,age,city,country) values (?,?,?,?)";
		return jdbc.update(sql,
				new Object[] { student.getStudentName(), student.getAge(), student.getCity(), student.getCountry() });

	}

	@Override
	public String delete(int id) {

		String c = "failed";
		String sql = "delete from Student where id=?";
		int status = jdbc.update(sql, id);
		if (status > 0) {
			c = "success";
		}

		return c;
	}

	@Override
	public String Create() {

		String sql = "create table academy ( id int,name varchar(25),mobile long)";

		int r = jdbc.update(sql);

		return "success";
	}

	@Override
	public List<Student> getall() {
		List<Student> student = jdbc.query("SELECT * FROM Student", new BeanPropertyRowMapper<Student>(Student.class));
		return student;

	}

	@Override
	public Student getsingle(int id) {

		return jdbc.queryForObject("select * from Student where id=?",
				new BeanPropertyRowMapper<Student>(Student.class), id);
	}

	@Override
	public int UPDATE(Student student, int id) {
		
	String sql="update Student set studentName=?,age=?,city=?,country=? where id=?";	
	return jdbc.update(sql,new Object[] {student.getStudentName(),student.getAge(),student.getCity(),student.getCountry(),id});
		 
	}

}
