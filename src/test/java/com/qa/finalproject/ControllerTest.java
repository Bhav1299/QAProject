package com.qa.finalproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.finalproject.domain.StuExDTO;
import com.qa.finalproject.domain.StuExams;
import com.qa.finalproject.rest.Controller;
import com.qa.finalproject.service.StuExService;

@SpringBootTest
public class ControllerTest {
	
	@MockBean
	private StuExService service;
	
	@Autowired
	private Controller controller;
	
	@Test
	public void testCreate() {
		StuExams testStuEx = new StuExams(1L, "Tester", "Tests", "Maths", 99, "A*");
		StuExDTO expected = new StuExDTO(testStuEx.getId(), testStuEx.getFirst(), testStuEx.getLast(), testStuEx.getSubject(), testStuEx.getResult(), testStuEx.getGrade());
		
		when(service.create(testStuEx)).thenReturn(testStuEx);
		
		assertThat(testStuEx).isEqualTo(controller.createMap(testStuEx));
		
		verify(service, times(1)).create(testStuEx);
	}

}
