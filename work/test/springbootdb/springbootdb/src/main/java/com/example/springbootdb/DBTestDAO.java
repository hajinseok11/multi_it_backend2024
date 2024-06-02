package com.example.springbootdb;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.springbootdb.dto.DeptDTO;

@Repository
public class DBTestDAO {
	@Autowired
	JdbcTemplate template;
	@Autowired
	SqlSession sqlsessionTemplate;
	public int jdbcTemplateTest() {
		return template.queryForObject("select count(deptno) from dept", Integer.class);
	}
	public List<DeptDTO> select() {
		return sqlsessionTemplate.selectList("com.multi.dbtest.select");
	}
}
