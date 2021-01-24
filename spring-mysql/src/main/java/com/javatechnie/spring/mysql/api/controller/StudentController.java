package com.javatechnie.spring.mysql.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechnie.spring.mysql.api.dao.StudentDao;
import com.javatechnie.spring.mysql.api.model.Student;

@RestController
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentDao dao;
	
	@PostMapping("/createStudent")
	public String createStudent(@RequestBody List<Student> student)
	{
		dao.saveAll(student);
		return "student created " + student.size();
	}
	
	@GetMapping("/getUserDetails/{id}")
	public Optional<Student> getStudentDetails(@PathVariable(value = "id") Integer id)
	{
		return dao.findById(id);
	}
	
	@PutMapping("updateStudentDetails")
	public List<Student> updateStudentDetails(@RequestBody List<Student> student)
	{
		return dao.saveAll(student);
	}

}
