package com.qa.finalproject.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.finalproject.domain.StuExams;
import com.qa.finalproject.service.StuExService;

@RestController
public class Controller {
	
	private StuExService service;

	public Controller(StuExService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/Create")
	public StuExams createMap(@RequestBody StuExams stuex) {
		return this.service.create(stuex);
	}

}
