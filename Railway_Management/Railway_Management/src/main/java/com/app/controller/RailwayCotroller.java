package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Category;
import com.app.entity.Railway;
import com.app.service.RailwayService;

@RestController
@RequestMapping("/railway")
public class RailwayCotroller {
	
	@Autowired
	private RailwayService railwayservice;

	
	@PostMapping
	public ResponseEntity<Railway> addNewRailway(@Valid @RequestBody Railway railway)
	{
		System.out.println("Valuse"+railway);
		Railway createtRailway= railwayservice.addRailway(railway);
		return new ResponseEntity<>(createtRailway,HttpStatus.CREATED);
	}
	
	@GetMapping("/category/{c}")
	public ResponseEntity<List<Railway>> getRailwayBycategory(@PathVariable Category c)
	{
		System.out.println("Category"+c);
		List<Railway> rlist=railwayservice.getAllRailway(c);
		return new ResponseEntity<>(rlist,HttpStatus.OK);
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteRailwayById(@PathVariable Long id)
	{
		System.out.println("Id"+id);
		railwayservice.deleteRailway(id);
		return new ResponseEntity<>("Row deleted",HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Railway>> payLoad()
	{
		List<Railway> rlist=railwayservice.payloadRailway();
		return new ResponseEntity<>(rlist,HttpStatus.OK);
	}
	
	@PutMapping
	public String updateRailway(@RequestBody Railway railway)
	{
		railwayservice.updateRailway( railway);
		return "Railway Updated!!!";
	}
	@GetMapping("/sort")
	public List<Railway> sortRailway()
	{
		return railwayservice.sortRailway();
		
	}
	
	
}
