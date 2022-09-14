package com.mindtree.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mindtree.student.entity.Student;
import com.mindtree.student.service.StudentService;
import com.mindtree.student.vo.College;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private StudentService studentService;
	
    @PostMapping
	public Student  addStudent(@RequestBody  Student student) {
		return studentService.addStud(student);
	}
    
    
    @PutMapping("/{sid}/{clid}")
    public String updateStudentCollege(@PathVariable int sid,@PathVariable int clid)
    {
    	College college=restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+clid, College.class);
    	if(college!=null) {
    		return studentService.updateCollege(sid,clid);
    		
    	}
    	return "College not Found";
    	
    }
    
    
    @GetMapping("/name-in-asc/{id}")
    public List<Student> gealltStudentByNames(@PathVariable int id){
    	return studentService.getByName(id);
    }
    
    
    @GetMapping("/age-in-desc/{id}")
    public List<Student> gealltStudentByAge(@PathVariable int id){
    	return studentService.getByAge(id);
    }
    
    
}
