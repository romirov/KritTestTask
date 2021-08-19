package com.krit.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.krit.entities.Nalog;
import java.util.logging.Logger;

/**
 * 
 * @author hanza
 * Класс для работы с базой данных
 * 
 */
public class DBService {
	private static String DB_DRIVER = "\"org.postgresql.Driver\"";
	private static String DB_CONNECTION = "jdbc:postgresql://192.168.88.250:5432/kritdb";
	private static String DB_USER = "krit";
	private static String DB_PASSWORD = "VYh2EbFwJLHKG2gh";
	private static Logger logger = Logger.getLogger(DBService.class.getName());
	private static Connection dbConnection;
	private static PreparedStatement preparedStatement;
	
	public DBService() {
		logger.info("Create connection to DB");
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}

	}
	
	public void insert(Nalog nalog) {
		String insertTableSQL = "INSERT INTO nalog1nom_omirov"
				+ "(fielda, fieldb, fieldv,"
				+ " field1, field2, field3, field4,field5,"
				+ " field6, field7, field8, field9, field10,"
				+ " field11, field12, field13, field14, field15,"
				+ " field16, field17, field18, field19, field20,"
				+ " field21, field22, field23, field24, field25, ter, dat) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		logger.info("Quaery to DB " + insertTableSQL);
		try {
			preparedStatement= dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, nalog.getFielda());
			preparedStatement.setString(2, nalog.getFieldb());
			preparedStatement.setString(3, nalog.getFieldv());
			preparedStatement.setString(4, nalog.getField1());
			preparedStatement.setString(5, nalog.getField2());
			preparedStatement.setString(6, nalog.getField3());
			preparedStatement.setString(7, nalog.getField4());
			preparedStatement.setString(8, nalog.getField5());
			preparedStatement.setString(9, nalog.getField6());
			preparedStatement.setString(10, nalog.getField7());
			preparedStatement.setString(11, nalog.getField8());
			preparedStatement.setString(12, nalog.getField9());
			preparedStatement.setString(13, nalog.getField10());
			preparedStatement.setString(14, nalog.getField11());
			preparedStatement.setString(15, nalog.getField12());
			preparedStatement.setString(16, nalog.getField13());
			preparedStatement.setString(17, nalog.getField14());
			preparedStatement.setString(18, nalog.getField15());
			preparedStatement.setString(19, nalog.getField16());
			preparedStatement.setString(20, nalog.getField17());
			preparedStatement.setString(21, nalog.getField18());
			preparedStatement.setString(22, nalog.getField19());
			preparedStatement.setString(23, nalog.getField20());
			preparedStatement.setString(24, nalog.getField21());
			preparedStatement.setString(25, nalog.getField22());
			preparedStatement.setString(26, nalog.getField23());
			preparedStatement.setString(27, nalog.getField24());
			preparedStatement.setString(28, nalog.getField25());
			preparedStatement.setString(29, nalog.getTer());
			preparedStatement.setString(30, nalog.getDat());
			preparedStatement.execute();
			logger.info("Insert is passed!");
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
	
	public void closeConnection() {
		logger.info("Close connection to DB");
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
		if (dbConnection != null) {
			try {
				dbConnection.close();
			} catch (SQLException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
	}
}
