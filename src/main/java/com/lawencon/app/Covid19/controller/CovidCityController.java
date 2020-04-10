package com.lawencon.app.Covid19.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.app.Covid19.model.CovidCity;
import com.lawencon.app.Covid19.service.CovidCityService;

@RestController
@RequestMapping("/city")
public class CovidCityController extends BaseController<CovidCity> {

	@Autowired
	private CovidCityService covidCityService;
	
	@GetMapping("/show")
	public ResponseEntity<List<CovidCity>> getList(){
		List<CovidCity> listCity = new ArrayList<>();
		try {
			listCity = covidCityService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<>(listCity, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listCity, HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> getInsert(@RequestBody String content){
		try {
			CovidCity city = readValue(content, CovidCity.class);
			covidCityService.insertCity(city);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to Insert", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}/{cityName}/{caseByCity}/{deathsByCity}/{recovered}")
	public ResponseEntity<?> getUpdate(@PathVariable("id") int id, @PathVariable("cityName")String cityName, @PathVariable("caseByCity") int caseByCity, @PathVariable("deathsByCity") int deathsByCity, @PathVariable("recovered") int recovered){
		try {
			covidCityService.updateCity(id, cityName, caseByCity, deathsByCity,recovered);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to Update", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping("/deleteId/{id}")
	public ResponseEntity<?> getDeleteById(@PathVariable("id") int id){
		try {
			covidCityService.deleteById(id);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Deleted", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
}
