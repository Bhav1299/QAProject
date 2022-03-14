package com.qa.finalproject.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
