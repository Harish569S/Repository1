package com.mindtree.college.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mindtree.college.entity.College;
import com.mindtree.college.repository.CollegeRepository;
import com.mindtree.college.vo.RequestedResponse;
import com.mindtree.college.vo.Student;


@Service
public class CollegeService {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CollegeRepository collegeRepository;

	
	public College addColl(College college) {
		return collegeRepository.save(college);
	}

	
	public College getCol(int id) {	
		College college= collegeRepository.findById(id).get();
		if(college==null) {
			return null;
		}
		return college;
	}
	
	
	
	public List<RequestedResponse> allcolleges() {
		List<RequestedResponse> all=new ArrayList<>();
       int n=collegeRepository.noOfColleges();
       for(int i=1;i<=n;i++) {
    	   RequestedResponse response=new RequestedResponse();
    	  
          College college=collegeRepository.findById(i).get();
    	   List<Student> students=restTemplate.getForObject("http://STUDENT-SERVICE/student/name-in-asc/"+i, List.class);
    	   response.setCollege(college);
    	   response.setStudents(students);
    	   all.add(response);
       }
		return all;
	}


	
	

	
	
}
