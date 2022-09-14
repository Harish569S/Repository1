package com.mindtree.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
	@Query(value="select * from student where col_id=:id order by name asc",nativeQuery = true)
	List<Student> getStudentsByName(@Param("id") int id);
	
	@Query(value="select * from student where col_id=:id order by age desc",nativeQuery = true)
	List<Student> getStudentsByAge(@Param("id") int id);
	
	
}
