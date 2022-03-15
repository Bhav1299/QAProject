package com.qa.finalproject.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	private StuExams mapToDto(StuExams stuex) {
		return this.mapper.map(stuex, StuExams.class);
	}

	public StuExams create(StuExams stuex) {
		return this.repo.save(stuex);
	}

	public List<StuExams> readAll() {
		return this.repo.findAll();
	}

	public StuExams readStuEx(Long id) {

		Optional<StuExams> requestedStuEx = repo.findById(id);

		return requestedStuEx.get();
	}

	public boolean delete(long id) {
		Optional<StuExams> existingOptional = this.repo.findById(id);
		if (existingOptional.isPresent()) {
			this.repo.deleteById(id);
			return !(this.repo.existsById(id));
		}
		return false;
	}

	@RequestMapping(value = "/Delete", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteAll() {
		this.repo.deleteAll();
		return true;
	}
	
	@Transactional
	public StuExams update(Long id, StuExams stuex) {
		Optional<StuExams> oc = this.repo.findById(id);
		StuExams existing = oc.get();

		existing.setFirst(stuex.getFirst());
		existing.setLast(stuex.getLast());
		existing.setSubject(stuex.getSubject());
		existing.setResult(stuex.getResult());
		existing.setGrade(stuex.getGrade());
		return this.repo.save(existing);
	}
}
