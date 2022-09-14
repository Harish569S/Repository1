package com.mindtree.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mindtree.college.entity.College;
import com.mindtree.college.repository.CollegeRepository;
import com.mindtree.college.service.CollegeService;
import com.mindtree.college.vo.RequestedResponse;


@RestController
@RequestMapping("/college")
public class CollegeController {
	@Autowired
	private CollegeRepository collegeRepository;
	
	@Autowired
	private CollegeService collegeService;
	
	@PostMapping
	public College addCollege(@RequestBody College college) {
		return collegeService.addColl(college);
	}
	
	
	@GetMapping("/with-students")
	public List<RequestedResponse> allCollegeWithStudents()
	{
		return collegeService.allcolleges();
	}
	
	@GetMapping("/{id}")
	public College getCollege(@PathVariable int id) {
		return collegeService.getCol(id);
	}
	
	@GetMapping
	public List<College> getCollege() {
		return collegeRepository.findAll();
	}
	
}
