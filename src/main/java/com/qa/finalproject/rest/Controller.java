package com.qa.finalproject.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.finalproject.domain.StuExDTO;
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

}
