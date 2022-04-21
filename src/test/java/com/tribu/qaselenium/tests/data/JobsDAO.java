package com.tribu.qaselenium.tests.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.Logger;

import com.tribu.qaselenium.testframework.testbase.DBConnection;
import com.tribu.qaselenium.testframework.testbase.PropertiesFile;
import com.tribu.qaselenium.testframework.testbase.TestLoggerFactory;

public class JobsDAO {

	private static final String DATA_BASE_URL = PropertiesFile.getProperties("db_url");
	private static final String DATA_BASE = PropertiesFile.getProperties(PropertiesFile.getProperties("env") + "_db");
	private static final String USER = PropertiesFile.getProperties("user_db");
	private static final String PASSWORD = PropertiesFile.getProperties("db_pass");
	private static final String SQL_SELECT = "SELECT * FROM " + DATA_BASE + ".jobs";
	protected Logger log = TestLoggerFactory.getInstance().getLogger();

	public Boolean verifyEmptyJobs() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Boolean emptyJobs = false;
		try {
			conn = DBConnection.getConnection(DATA_BASE_URL, DATA_BASE, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			if (rs.next()) {
				emptyJobs = false;
			}else {
				emptyJobs = true;
			}
			log.info("emptyJobs : " + emptyJobs);
		} catch (SQLException e) {
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
		return emptyJobs;
	}
}
