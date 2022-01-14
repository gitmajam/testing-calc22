package com.tribu.qaselenium.tests.mazaprendo.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tribu.qaselenium.testframework.testbase.DBConnection;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;

public class UserLessonAssignDAO {

	
	private static final String DATA_BASE_URL = PropertiesFile.getProperties("db_url"); 
	private static final String DATA_BASE = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_ma_db");
	private static final String USER = PropertiesFile.getProperties("user_db");  
	private static final String PASSWORD = PropertiesFile.getProperties("db_pass");
	private static final String SQL_SELECT = "SELECT username FROM " + DATA_BASE + ".assigned_lessons_users WHERE username = ?";
	private static final String SQL_DELETE = "DELETE FROM " + DATA_BASE + ".assigned_lessons_users WHERE username = ?";

	public Iterator<UserLessonAssign> select(UserLessonAssign person) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		UserLessonAssign personFound = null;
		List<UserLessonAssign> persons = new ArrayList<>();
		try {
			conn = DBConnection.getConnection(DATA_BASE_URL, DATA_BASE, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT);
			stmt.setString(1, person.getUsername());
			rs = stmt.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				personFound = new UserLessonAssign(username);
				persons.add(personFound);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		} finally {
			try {
				DBConnection.close(rs);
				DBConnection.close(stmt);
				DBConnection.close(conn);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return persons.iterator();
	}

	public int remove(UserLessonAssign person) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registers = 0;
		try {
			conn = DBConnection.getConnection(DATA_BASE_URL, DATA_BASE, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setString(1, person.getUsername());
			registers = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			try {
				DBConnection.close(stmt);
				DBConnection.close(conn);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return registers;
	}
}
