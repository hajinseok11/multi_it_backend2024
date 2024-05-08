package com.multi.pool;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.StopWatch;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class ConnectionPoolTest {
	@Autowired
	DataSource ds;
	@Test
	public void test() {
		System.out.println(ds);
		try {
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();
			Connection con1 = ds.getConnection();
			Connection con2 = ds.getConnection();
			Connection con3 = ds.getConnection();
			Connection con4 = ds.getConnection();
			Connection con5 = ds.getConnection();
			Connection con6 = ds.getConnection();
			Connection con7 = ds.getConnection();
			Connection con8 = ds.getConnection();
			Connection con9 = ds.getConnection();
			Connection con10 = ds.getConnection();
			stopWatch.stop();
			System.out.println(stopWatch.prettyPrint());
			System.out.println("===============================================");
			System.out.println(con1);
			System.out.println(con2);
			System.out.println(con3);
			System.out.println(con4);
			System.out.println(con5);
			System.out.println(con6);
			System.out.println(con7);
			System.out.println(con8);
			System.out.println(con9);
			System.out.println(con10);
			System.out.println("===============================================");
			Connection con11 = ds.getConnection();
			System.out.println(con11);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
