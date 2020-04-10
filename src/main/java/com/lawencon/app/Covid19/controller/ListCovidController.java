package com.lawencon.app.Covid19.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.app.Covid19.model.ListCovid;
import com.lawencon.app.Covid19.service.ListCovidService;

@RestController
@RequestMapping("/Home")
public class ListCovidController extends BaseController<ListCovid>{
	
	@Autowired
	private ListCovidService listCovidService;
	
	@GetMapping("/show")
	public ResponseEntity<?> getList(){
		List<ListCovid> listCovid = new ArrayList<>();
		try {
			listCovid = listCovidService.findAll();
		} catch (Exception e) {
			return new ResponseEntity<>(listCovid, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listCovid, HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> getInsert(){
		try {
			listCovidService.insert();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to Insert", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}/{totalCases}/{totalDeaths}/{totalRecovered}")
	public ResponseEntity<?> getUpdate(@PathVariable("id") int id, @PathVariable("totalCases") int totalCases, @PathVariable("totalDeaths") int totalDeaths, @PathVariable("totalRecovered")int totalRecovered){
		try {
			listCovidService.update(id, totalCases, totalDeaths, totalRecovered);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to Update", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping("/deleteId/{id}")
	public ResponseEntity<?> getDeleteById(@PathVariable("id") int id){
		try {
			listCovidService.deleteById(id);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Deleted", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
}
