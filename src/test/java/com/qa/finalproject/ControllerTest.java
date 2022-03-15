package com.qa.finalproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
	void createTest() {
		StuExams TEST_ASSIGNEE = new StuExams(4L, "Porter", "Corter", "maths", 99, "A*");
		StuExams TEST_DTO = new StuExams(TEST_ASSIGNEE.getId(), TEST_ASSIGNEE.getFirst(), TEST_ASSIGNEE.getLast(),
				TEST_ASSIGNEE.getSubject(), TEST_ASSIGNEE.getResult(), TEST_ASSIGNEE.getGrade());

		when(this.service.create(TEST_ASSIGNEE)).thenReturn(TEST_ASSIGNEE);

		ResponseEntity<StuExams> result = this.controller.createMap(TEST_DTO);

		Assertions.assertThat(result).isEqualTo(new ResponseEntity<StuExams>(TEST_ASSIGNEE, HttpStatus.CREATED));
	}

	@Test
	void readAllTest() {
		StuExams TESTA = new StuExams(1L, "Jane", "John", "Maths", 99, "A*");
		StuExams TESTB = new StuExams(2L, "gane", "gohn", "Maths", 98, "A*");
		StuExams TESTC = new StuExams(3L, "fane", "fohn", "Maths", 97, "A*");
		List<StuExams> stuList = List.of(TESTA, TESTB, TESTC);

		when(this.service.readAll()).thenReturn(stuList);

		ResponseEntity<List<StuExams>> result = this.controller.readAll();

		Assertions.assertThat(result).isEqualTo(ResponseEntity.ok(stuList));
	}

	@Test
	void readStuExTest() {
		Long id = 1L;
		StuExams TEST_DTO = new StuExams(id, "man", "woman", "maths", 99, "A*");

		when(this.service.readStuEx(id)).thenReturn(TEST_DTO);

		ResponseEntity<StuExams> result = this.controller.readStuEx(id);

		Assertions.assertThat(result).isEqualTo(ResponseEntity.ok(TEST_DTO));
	}

	@Test
	void removeStuEx() {
		long id = 1L;
		when(this.service.delete(id)).thenReturn(true);

		ResponseEntity<Object> result = this.controller.removeStuEx(id);

		Assertions.assertThat(result).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

	@Test
	void removeStuExUnsuccessful() {
		long id = 1L;
		when(this.service.delete(id)).thenReturn(false);

		ResponseEntity<Object> result = this.controller.removeStuEx(id);

		Assertions.assertThat(result).isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@Test
	void removeStuExamsTest() {
		when(this.service.deleteAll()).thenReturn(false);

		ResponseEntity<Object> result = this.controller.removeStuExams();

		Assertions.assertThat(result).isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@Test
	void updateAssigneeTest() {
		Long id = 1L;
		StuExams TEST_ASSIGNEE_UPDATE = new StuExams(id, "Tester", "Test", "Maths", 99, "A*");
		StuExams TEST_DTO_UPDATE = new StuExams(id, TEST_ASSIGNEE_UPDATE.getFirst(), TEST_ASSIGNEE_UPDATE.getLast(),
				TEST_ASSIGNEE_UPDATE.getSubject(), TEST_ASSIGNEE_UPDATE.getResult(), TEST_ASSIGNEE_UPDATE.getGrade());

		when(this.service.update(id, TEST_ASSIGNEE_UPDATE)).thenReturn(TEST_DTO_UPDATE);

		ResponseEntity<StuExams> result = this.controller.updateStuEx(id, TEST_ASSIGNEE_UPDATE);

		Assertions.assertThat(result).isEqualTo(new ResponseEntity<StuExams>(TEST_DTO_UPDATE, HttpStatus.ACCEPTED));
	}
	
	@Test
	void removeStuExamsUnsuccessful() {
		when(this.service.deleteAll()).thenReturn(false);

		ResponseEntity<Object> result = this.controller.removeStuExams();

		Assertions.assertThat(result).isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}

}
