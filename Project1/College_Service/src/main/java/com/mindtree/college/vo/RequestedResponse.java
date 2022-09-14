package com.mindtree.college.vo;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.college.entity.College;

public class RequestedResponse {

	private College college;
	
	private List<Student> students=new ArrayList<>();

	public RequestedResponse() {
		super();
	}

	public RequestedResponse(College college, List<Student> students) {
		super();
		this.college = college;
		this.students = students;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "RequestedResponse [college=" + college + ", students=" + students + "]";
	}
	
	
}
