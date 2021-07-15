package co.jelly.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public Connection cnn;	//연결객체
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String	url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "demo";
	private String password = "1234";
	
	public DAO() {
		try {
			Class.forName(driver);
			cnn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
