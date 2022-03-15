package com.qa.finalproject.rest;

import java.util.List;

import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RestController;

import com.qa.finalproject.domain.StuExams;
import com.qa.finalproject.repository.StuExamsInt;
import com.qa.finalproject.service.StuExService;

@RestController
public class Controller {

	private StuExService service;

	@Autowired
	public Controller(StuExService service) {
		super();
		this.service = service;
	}

	@PostMapping("/Create")
	public ResponseEntity<StuExams> createMap(@RequestBody StuExams stuex) {
		return new ResponseEntity<>(this.service.create(stuex), HttpStatus.CREATED);
	}

	@GetMapping("/Read/All")
	public ResponseEntity<List<StuExams>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}

	@GetMapping("/Read/{id}")
	public ResponseEntity<StuExams> readStuEx(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.readStuEx(id));
	}
	
	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<Object> removeStuEx(@PathVariable long id) {
		return new ResponseEntity<>(this.service.delete(id) ? HttpStatus.NO_CONTENT : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/Delete")
	public ResponseEntity<Object> removeStuExams() {
		return new ResponseEntity<>(this.service.deleteAll() ? HttpStatus.NO_CONTENT : HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/Update/{id}")
	public ResponseEntity<StuExams> updateStuEx(@PathVariable("id") Long id, @RequestBody StuExams stuex) {
		return new ResponseEntity<>(this.service.update(id, stuex), HttpStatus.ACCEPTED);
	}
	
	

}
