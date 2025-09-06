package com.example.studentcrudcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.studentcrud.Student;
import com.example.studentrepository.StudentRepository;

@RestController
public class StudentCrudController {
	
	@Autowired
	StudentRepository repo;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> returnStudents = repo.findAll();
		return returnStudents;
	}
	
	@PostMapping("/create")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student st) {
		Student createStudent= repo.save(st);
		return createStudent;
		
	}
	
	@GetMapping("student/{id}")
	public Student getStudent(@PathVariable int id)
	{
		Student stud = repo.findById(id).get();
		return stud;
	}
	
	@PutMapping("update/{id}")
	public Student updateStudent(@PathVariable int id) {
		 Student stu = repo.findById(id).get();
		 stu.setMarks(1);
		 stu.setName("mafikul");
		 repo.save(stu);
		 return stu;
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> removeStudent(@PathVariable int id)
	{
		Student stud = repo.findById(id).get();
	      repo.delete(stud);
	      return ResponseEntity.status(HttpStatus.GONE).body("record deleted "+stud.getName());
	}
}
