package com.qa.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.finalproject.domain.StuExams;

@Repository
public interface StuExamsInt extends JpaRepository<StuExams, Long> {
	
}
