package com.tribu.qaselenium.tests.mazaprendo.data;

public class TeacherCourseAssign {

	private String username;

	public TeacherCourseAssign() {

	}

	public TeacherCourseAssign(String username) {
		this.username = username;
	}

	public void setUsername(String username) {
		this.username = username;

	}

	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "Person [username=" + username + "]";
	}

}
