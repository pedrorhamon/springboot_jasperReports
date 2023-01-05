package com.starking.jasper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	private static final String URL = "jdbc:mysql://localhost/jaspercurso?createDatabaseIfNotExist=true&serverTimeZone";
	private static final String USER = "root";
	private static final String PASS = "root";
	private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
	
	public static Connection connection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASS);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return connection;
	}
}
