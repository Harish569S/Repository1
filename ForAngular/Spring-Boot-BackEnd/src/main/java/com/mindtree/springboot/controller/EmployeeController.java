package com.mindtree.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.springboot.entity.Employee;
import com.mindtree.springboot.exception.ResourseNotFoundException;
import com.mindtree.springboot.repository.EmployeeRepository;


//@CrossOrigin(origins="http://localhost:4200/")
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//Fetch all employees
	@GetMapping("/employees")
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	
	//To create add an employee
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//Get Employee By id
	@GetMapping("/employees/{id}")	
	public ResponseEntity<Employee> getByID(@PathVariable Long id) throws ResourseNotFoundException {
		Employee emp=employeeRepository.findById(id).
				orElseThrow(() -> new ResourseNotFoundException("Employee does not exist id:"+id));

		return ResponseEntity.ok(emp);
	}
	
	// update employee rest api
	
		@PutMapping("/employees/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) 
				throws ResourseNotFoundException{
			Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourseNotFoundException("Employee not exist with id :" + id));
			
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setEmail(employeeDetails.getEmail());
			
			Employee updatedEmployee = employeeRepository.save(employee);
			return ResponseEntity.ok(updatedEmployee);
			//return new  ResponseEntity<>(updatedEmployee,HttpStatus.OK);

		}
		
		
		//Deleting by id
		@DeleteMapping("/employees/{id}")
		public ResponseEntity<Map<String,Boolean>> deleteById(@PathVariable Long id) throws Exception{
			Employee employee = employeeRepository.findById(id)
					.orElseThrow(() -> new ResourseNotFoundException("Employee not exist with id :" + id));
			employeeRepository.delete(employee);
			Map<String,Boolean> response=new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			
			return ResponseEntity.ok(response);
			
		}
		
		
		

}





//@GetMapping("/employees/{id}")	
//public Employee getByID(@PathVariable Long id) {
//	Employee emp=employeeRepository.findById(id).get();
//	return emp;
//}


//From RameshMF

////get employee by id rest api
//		@GetMapping("/employees/{id}")
//		public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourseNotFoundException {
//			Employee employee = employeeRepository.findById(id)
//					.orElseThrow(() -> new ResourseNotFoundException("Employee not exist with id :" + id));
//			return ResponseEntity.ok(employee);
//		}
//	
