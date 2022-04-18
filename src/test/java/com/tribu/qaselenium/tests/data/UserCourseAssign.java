package com.tribu.qaselenium.tests.data;

public class UserCourseAssign {

	private String username;

	public UserCourseAssign() {

	}

	public UserCourseAssign(String username) {
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
