package com.qa.finalproject.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.finalproject.domain.StuExams;
import com.qa.finalproject.repository.StuExamsInt;

@Service
public class StuExService {

	private StuExamsInt repo;

	public StuExService(StuExamsInt repo, ModelMapper mapper) {
		super();
		this.repo = repo;
	}

	public StuExams create(StuExams stuex) {
		return this.repo.save(stuex);
	}

}
