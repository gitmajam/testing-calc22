package com.tribu.qaselenium.tests.mazaprendo.data;

public class UserLessonAssign {

	private String username;

	public UserLessonAssign() {

	}

	public UserLessonAssign(String username) {
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
