package com.qa.finalproject.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.finalproject.domain.StuExDTO;
import com.qa.finalproject.domain.StuExams;
import com.qa.finalproject.repository.StuExamsInt;

@Service
public class StuExService {

	private StuExamsInt repo;
	private ModelMapper mapper;

	@Autowired
	public StuExService(StuExamsInt repo) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private StuExDTO mapToDto(StuExams stuex) {
		return this.mapper.map(stuex, StuExDTO.class);
	}

	public StuExams create(StuExams stuex) {
		return this.repo.save(stuex);
	}

}
