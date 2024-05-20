package com.multi.erp.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MemberDAOImpl implements MemberDAO {
	private SqlSession sessionTemplate;
	@Autowired
	public MemberDAOImpl(SqlSession sessionTemplate) {
		super();
		this.sessionTemplate = sessionTemplate;
	}

	@Override
	public List<MemberDTO> getTreeEmpList(String deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(MemberDTO user) {
		// TODO Auto-generated method stub
		return sessionTemplate.insert("com.multi.erp.member.insert", user);
	}

	@Override
	public List<MemberDTO> getMemberList() {
		// TODO Auto-generated method stub
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
		return sessionTemplate.selectOne("com.multi.erp.member.login", loginUser);
	}

	@Override
	public boolean idCheck(String id) {
		// TODO Auto-generated method stub
		boolean result = true;
		MemberDTO user = sessionTemplate.selectOne("com.multi.erp.member.idcheck",id);
		if (user==null) { // 해당 아이디가 디비에 존재하지 않는 경우
			result = false;
		}
		return false;
	}

	@Override
	public MemberDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
