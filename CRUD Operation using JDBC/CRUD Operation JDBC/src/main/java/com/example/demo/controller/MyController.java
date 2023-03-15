package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ServiceStudent;

@RestController
public class MyController {
	
	@Autowired
	ServiceStudent std;
	
	
	//insert
	@PostMapping("/students")   //correction 1.change put to post 2. use same name for parameters
	
	public String hello(@RequestBody Student student)
	{
		int s =std.insert(student);
		return s+" No of rows Affected";
	}
	
	
	//delete
	
	@DeleteMapping("/students/{id}")  // correction use same name for parameters
	public String akshay(@PathVariable String id )
	{
		String s= std.delete(Integer.parseInt(id));
		return s;
		
	}
	
	
	//create table
	 @PostMapping("/studentss")
	public String akshay()
	{
		String t=  std.Create();
		return "Created";
		
	}
	
	//read all record from table 
	 @GetMapping("/students") // correction use same name for parameters
	 public ResponseEntity<List<Student>> selectallStudent()
	 {
		return new ResponseEntity<>(std.getall(),HttpStatus.OK);
		
	 }
	
	// read single record from table
	 @GetMapping("/students/{id}") // correction use same name for parameters
	 public Student getsingle(@PathVariable int id)
		{
			return std.getsingle(id);
			
		}
	 
	 // update                      // NEW METHOD added
	 @PutMapping("/students/{id}") // correction use same name for parameters
	 public String uppdate(@RequestBody Student student,@PathVariable int id) 
	 {
		 return std.UPDATE(student, id)+" no of rows update";
	 }
     

}
