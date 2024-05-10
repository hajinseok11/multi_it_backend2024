package com.multi.erp.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	// mybatis의 핵심클래스인 Sqlsession을 이용해서 sql문이 실행
	private SqlSession sessionTemplate;
	@Autowired 
	public MemberDAOImpl(SqlSession sqlSessionTemplate) {
		super();
		this.sessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<MemberDTO> getTreeEmpList(String deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemberDTO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberDTO> getMemberList() {
		System.out.println("MemberDAO");
		return sessionTemplate.selectList("com.multi.erp.member.selectall");
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDTO> search(String column, String search, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(MemberDTO user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberDTO login(MemberDTO loginUser) {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("com.multi.erp.member.login",loginUser);
	}

	@Override
	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MemberDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
