package com.mindtree.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mindtree.springboot.entity.Vehicle;

import com.mindtree.springboot.service.VehiceService;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	private VehiceService vehiceService;
	
	
	@PostMapping
	public Vehicle createEmployee(@RequestBody Vehicle vehicle) {
		return vehiceService.add(vehicle);
	}
	
	@GetMapping("/{id}")	
	public ResponseEntity<Vehicle> getByID(@PathVariable int id) {
		Vehicle vehicle=vehiceService.findDetails(id);
		return    ResponseEntity.ok(vehicle);
		
	}
	

}
