package com.qa.finalproject.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StuExams {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String firstName;
	private String lastName;
	private String subject;
	private int result;
	private String grade;
	
	public StuExams() {
		super();
	}
	
	public StuExams(String firstName, String lastName, String subject, int result, String grade) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.subject = subject;
		this.result = result;
		this.grade = grade;
	}
	
	public StuExams(long id, String firstName, String lastName, String subject, int result, String grade) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return Objects.hash(firstName, grade, id, lastName, result, subject);
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
		return Objects.equals(firstName, other.firstName) && Objects.equals(grade, other.grade) && id == other.id
				&& Objects.equals(lastName, other.lastName) && result == other.result
				&& Objects.equals(subject, other.subject);
	}

	@Override
	public String toString() {
		return "StuExams [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject
				+ ", result=" + result + ", grade=" + grade + "]";
	}
	

}
