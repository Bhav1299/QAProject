package com.qa.finalproject.service;

import org.springframework.stereotype.Service;

import com.qa.finalproject.domain.StuExams;
import com.qa.finalproject.repository.StuExamsInt;

@Service
public class StuExService {

	private StuExamsInt repo;

	public StuExService(StuExamsInt repo) {
		super();
		this.repo = repo;
	}
	
	public StuExams create(StuExams newStuEx) {
		return this.repo.save(newStuEx);
	}

}
