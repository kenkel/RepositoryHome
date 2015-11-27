package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDataBaseConnector {

	public static void main(String[] args) {	
	try{
		initDataBaseDriver();
		connectionToDataBase("jdbc:mysql://localhost/mysql", "root", "root");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	
	}
		
	public static void initDataBaseDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver init complete! ");
	}

	public static void connectionToDataBase(String url,String userName,String password) throws SQLException{
		//User Id=root;Host=localhost;Database=mysql;Character Set=utf8
		
			Connection connectionToDB = DriverManager.getConnection(url, userName, password);
			System.out.println("connection sucesfull! ");
			connectionToDB.close();
			System.out.println("Connection close! ");
	}

}
