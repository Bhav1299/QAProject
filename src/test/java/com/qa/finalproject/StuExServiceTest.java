package com.qa.finalproject;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.finalproject.domain.StuExams;
import com.qa.finalproject.repository.StuExamsInt;
import com.qa.finalproject.service.StuExService;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class StuExServiceTest {

	@MockBean
	private StuExamsInt repo;

	@MockBean
	private ModelMapper mapper;

	@Autowired
	StuExService service;

	@Test
	void createMapTest() {
		StuExams TEST_ASSIGNEE = new StuExams(1L, "Tester", "Testy", "Maths", 99, "A*");
		StuExams TEST = new StuExams(TEST_ASSIGNEE.getId(), TEST_ASSIGNEE.getFirst(), TEST_ASSIGNEE.getLast(),
				TEST_ASSIGNEE.getSubject(), TEST_ASSIGNEE.getResult(), TEST_ASSIGNEE.getGrade());

		when(this.repo.save(Mockito.any(StuExams.class))).thenReturn(TEST_ASSIGNEE);
		when(this.mapper.map(TEST_ASSIGNEE, StuExams.class)).thenReturn(TEST);

		StuExams result = this.service.create(TEST_ASSIGNEE);

		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(TEST);

		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(StuExams.class));
	}

	@Test
	void readStuEx() {
		Long id = 1L;
		StuExams TEST_ASSIGNEE = new StuExams(1L, "Tester", "Testy", "Maths", 99, "A*");
		Optional<StuExams> TEST_OPTIONAL = Optional.of(TEST_ASSIGNEE);
		StuExams TEST = new StuExams(TEST_ASSIGNEE.getId(), TEST_ASSIGNEE.getFirst(), TEST_ASSIGNEE.getLast(),
				TEST_ASSIGNEE.getSubject(), TEST_ASSIGNEE.getResult(), TEST_ASSIGNEE.getGrade());

		Mockito.when(this.repo.findById(id)).thenReturn(TEST_OPTIONAL);
		Mockito.when(this.mapper.map(TEST_ASSIGNEE, StuExams.class)).thenReturn(TEST);

		StuExams result = this.service.readStuEx(id);

		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(TEST);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}

	@Test
	void readStuExams() {
		StuExams TEST_ASSIGNEE1 = new StuExams(1L, "Tester", "Testy", "Maths", 99, "A*");
		StuExams TEST_ASSIGNEE2 = new StuExams(1L, "Tester", "Testy", "Maths", 99, "A*");
		StuExams TEST_ASSIGNEE3 = new StuExams(1L, "Tester", "Testy", "Maths", 99, "A*");
		StuExams TEST1 = new StuExams(1L, "Tester", "Testy", "Maths", 99, "A*");
		StuExams TEST2 = new StuExams(1L, "Tester", "Testy", "Maths", 99, "A*");
		StuExams TEST3 = new StuExams(1L, "Tester", "Testy", "Maths", 99, "A*");
		List<StuExams> ASSIGNEE_LIST = List.of(TEST_ASSIGNEE1, TEST_ASSIGNEE2, TEST_ASSIGNEE3);
		List<StuExams> LIST = List.of(TEST1, TEST2, TEST3);

		Mockito.when(this.repo.findAll()).thenReturn(ASSIGNEE_LIST);
		Mockito.when(this.mapper.map(TEST_ASSIGNEE1, StuExams.class)).thenReturn(TEST1);
		Mockito.when(this.mapper.map(TEST_ASSIGNEE2, StuExams.class)).thenReturn(TEST2);
		Mockito.when(this.mapper.map(TEST_ASSIGNEE3, StuExams.class)).thenReturn(TEST3);

		List<StuExams> result = this.service.readAll();

		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(LIST);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void removeStuExTest() {
		Mockito.when(this.repo.findById(1L))
				.thenReturn(Optional.of(new StuExams(1L, "Tester", "Testy", "Maths", 99, "A*")));

		this.service.delete(1L);

		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
	}

	@Test
	void updateTest() {
		Long id = 1L;
		StuExams TEST_ASSIGNEE = new StuExams(id, "Tester", "Testy", "Maths", 99, "A*");
		StuExams TEST_ASSIGNEE_UPDATE = new StuExams(id, "Testier", "Tester", "Maths", 100, "A*");
		Optional<StuExams> TEST_OPTIONAL = Optional.of(TEST_ASSIGNEE);
		StuExams TEST_UPDATE = new StuExams(TEST_ASSIGNEE_UPDATE.getId(), TEST_ASSIGNEE_UPDATE.getFirst(),
				TEST_ASSIGNEE_UPDATE.getLast(), TEST_ASSIGNEE_UPDATE.getSubject(), TEST_ASSIGNEE_UPDATE.getResult(),
				TEST_ASSIGNEE_UPDATE.getGrade());

		Mockito.when(this.repo.findById(id)).thenReturn(TEST_OPTIONAL);
		Mockito.when(this.repo.save(Mockito.any(StuExams.class))).thenReturn(TEST_ASSIGNEE_UPDATE);
		Mockito.when(this.mapper.map(TEST_ASSIGNEE_UPDATE, StuExams.class)).thenReturn(TEST_UPDATE);

		StuExams result = this.service.update(id, TEST_ASSIGNEE_UPDATE);

		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(TEST_UPDATE);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(Mockito.any(StuExams.class));
	}


}
