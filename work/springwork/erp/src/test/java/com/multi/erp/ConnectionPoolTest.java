package com.multi.erp;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/config/spring-config.xml"})
@WebAppConfiguration
public class ConnectionPoolTest {
	@Autowired
	DataSource ds;
	@Autowired
	JdbcTemplate template;
	@Autowired
	SqlSession sessionTemplate;
	@org.junit.Test
	public void test() {
		try {
			Connection con = ds.getConnection();
			System.out.println(sessionTemplate);
			System.out.println(con);
			System.out.println(template);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
