package com.mindtree.student.vo;

public class College {

	
	private int id;
	
	private String collegeName;
	
	private int totalStudents;

	public College() {
		super();
	}

	public College(String collegeName, int totalStudents) {
		super();
		this.collegeName = collegeName;
		this.totalStudents = totalStudents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public int getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", collegeName=" + collegeName + ", totalStudents=" + totalStudents + "]";
	}
	
	
}
