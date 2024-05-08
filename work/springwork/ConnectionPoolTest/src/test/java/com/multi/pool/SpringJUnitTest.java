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
// @RunWith는 단위테스트 실행방법을 확장해서 스프링과 연동해서 작업하기 위한 환경을 설정
@RunWith(SpringJUnit4ClassRunner.class)
// 스프링 설정파일의 위치를 정의하기 위한 어노테이션
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
// 스프링 레거시 프로젝트에서 스프링MVC 테스트 환경을 셋팅하기 위해서 설정하는 어노테이션
@WebAppConfiguration
public class SpringJUnitTest {
	@Autowired
	DataSource ds;
	@Test
	public void test() {
		assertNotNull(ds);
		System.out.println(ds);
		Connection con;
		try {
			con = ds.getConnection();
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
