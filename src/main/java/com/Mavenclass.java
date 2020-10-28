package com;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Mavenclass {

	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
//			DriverManager.getDriver("com.mysql.cj.jdbc.Driver");
//		    Driver d = new com.mysql.cj.jdbc.Driver();
//			DriverManager.deregisterDriver(d);
//			FileInputStream fis = new FileInputStream("database.properties");
//			Properties p = new Properties();
//			p.load(fis);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			Statement st = con.createStatement();
			System.out.println("enter name");
			String name = sc.next();
			System.out.println("enter number");
			int num = sc.nextInt();
			
//			 st.execute("insert into Jdbc1 values ("+num+",'"+ name+"')");
//			 
//			 System.out.println("Insertion is successfull");
			ResultSet rs = st.executeQuery("select * from jdbc1");
			while(rs.next()){
				System.out.println(rs.getInt(1));
			}
		st.close();
		con.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
