package com.example.demo.Util;

import java.sql.*;

public class DataConnect {
	private static Connection con;//creating reference variable of Connection
	private DataConnect(){
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//for mysql 8 write
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//It is loading Driver class from jar file
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/junemap","root","mysql");
			/*jdbc-protoocal
			 * mysql-sub protocol
			 * localhost-address of current
			 * 3306 port number
			 * junemap-database name
			 * root-username
			 * mysql-password
			 */
			System.out.println("Connection established");
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public static Connection getconnect(){
		DataConnect c=new DataConnect();
		return con;
	}

}