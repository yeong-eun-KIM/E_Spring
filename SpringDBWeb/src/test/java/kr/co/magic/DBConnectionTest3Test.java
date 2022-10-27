package kr.co.magic;


import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.checkerframework.framework.qual.AnnotatedFor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DBConnectionTest3Test {
	
	@Test
	public void springJdbcConnectionTest() throws SQLException {
		ApplicationContext ac = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		DataSource ds = ac.getBean(DataSource.class);
		
		Connection conn = ds.getConnection();
		
		//괄호안의 조건식이 true이면 테스트 성공, 아니면 실패
		assertTrue(conn != null);
	}

}
