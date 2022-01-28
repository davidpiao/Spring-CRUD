package com.crud.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	        // server - dbname - id - pwd
	        con= DriverManager.getConnection("jdbc:mysql://walab.handong.edu/PP3_21700266","PP3_21700266","oy7aiTie");  
	    }catch(Exception e){
	    	System.out.println(e);
	    }  
	    return con;  
	}  
	
//	public static void main(String ars[]) {
//		Connection conn = getConnection();
//		if(conn != null)
//			System.out.println("DB 연결됨!");
//		else
//			System.out.println("DB 연결중 오류 !");
//	}
}