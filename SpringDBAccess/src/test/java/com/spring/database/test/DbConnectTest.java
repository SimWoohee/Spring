package com.spring.database.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


public class DbConnectTest {
	
	//8점대 driver 사용은 .cj가 붙음
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	                                           //db포트,db스키마 이름
	private String url = "jdbc:mysql://localhost:3306/spring?serverTimezone=Asia/Seoul";
	private String uid = "root";
	private String upw = "mysql";
	@Test
	public void connectTest() {
		Connection conn = null;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, uid, upw);
			System.out.println("DB 커넥션 성공");
			System.out.println("conn: " + conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
