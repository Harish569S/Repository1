package com.mindtree.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.mindtree.student.entity.Student;
import com.mindtree.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	public Student addStud(Student student) {
		return studentRepository.save(student);
	}


	public String updateCollege(int sid, int clid) {
		Student student=studentRepository.findById(sid).get();
		
		if(student==null) {
			return "Student not Found";
		}
		
		student.setColId(clid);
		return studentRepository.save(student).toString();
	}


	public List<Student> getByName(int id) {
		return studentRepository.getStudentsByName(id);
	}


	public List<Student> getByAge(int id) {
		return studentRepository.getStudentsByAge(id);
	}

}
