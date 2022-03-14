package com.qa.finalproject.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StuExams {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column
	private String first;
	
	@Column
	private String last;
	
	@Column
	private String subject;
	
	@Column
	private int result;
	
	@Column
	private String grade;
	
	public StuExams() {
		super();
	}
	
	public StuExams(String first, String grade, String last, int result, String subject) {
		super();
		this.first = first;
		this.last = last;
		this.subject = subject;
		this.result = result;
		this.grade = grade;
	}
	
	public StuExams(long id, String first, String last, String subject, int result, String grade) {
		super();
		this.id = id;
		this.first = first;
		this.last = last;
		this.subject = subject;
		this.result = result;
		this.grade = grade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, grade, id, last, result, subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StuExams other = (StuExams) obj;
		return Objects.equals(first, other.first) && Objects.equals(grade, other.grade) && id == other.id
				&& Objects.equals(last, other.last) && result == other.result
				&& Objects.equals(subject, other.subject);
	}

	@Override
	public String toString() {
		return "StuExams [id=" + id + ", firstName=" + first + ", lastName=" + last + ", subject=" + subject
				+ ", result=" + result + ", grade=" + grade + "]";
	}
	

}
