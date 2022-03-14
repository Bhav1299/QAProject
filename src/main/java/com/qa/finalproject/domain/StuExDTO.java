package com.qa.finalproject.domain;

import javax.persistence.Column;

public class StuExDTO {

	private Long id;
	private String first;
	private String last;
	private String subject;
	private int result;
	private String grade;

	public StuExDTO() {
		super();
	}

	public StuExDTO(Long id, String first, String last, String subject, int result, String grade) {
		super();
		this.id = id;
		this.first = first;
		this.last = last;
		this.subject = subject;
		this.result = result;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	public String toString() {
		return "StuExDTO [id=" + id + ", first=" + first + ", last=" + last + ", subject=" + subject + ", result="
				+ result + ", grade=" + grade + "]";
	}

}
