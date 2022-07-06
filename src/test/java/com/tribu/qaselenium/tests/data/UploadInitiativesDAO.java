package com.tribu.qaselenium.tests.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tribu.qaselenium.testframework.testbase.PropertiesFile;
import com.tribu.qaselenium.testframework.utilities.DBConnection;

public class UploadInitiativesDAO {

	private static final String DATA_BASE_URL = PropertiesFile.getProperties("db_url"); 
	private static final String DATA_BASE = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_db");
	private static final String USER = PropertiesFile.getProperties("user_db");  
	private static final String PASSWORD = PropertiesFile.getProperties("db_pass");
	private static final String SQL_DELETE = "DELETE FROM " + DATA_BASE + ".upload_iniciatives";

	public int remove() {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registers = 0;
		try {
			conn = DBConnection.getConnection(DATA_BASE_URL, DATA_BASE, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_DELETE);
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
