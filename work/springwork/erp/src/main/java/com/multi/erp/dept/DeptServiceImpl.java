package com.multi.erp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// 컨트롤러가 전달한 클라이언트에서 넘어온 데이터를 가공해서 db에 넘겨주거나 db에서 받은 데이터를 가공해서 컨트롤러에 넘겨주는 일을 담당
// DAO의 메소드를 호출
// 비지니스 로직을 처리
// 트랜잭션 처리를 할 수 있다.
@Service
public class DeptServiceImpl implements DeptService {
	DeptDAO dao;
	@Autowired
	public DeptServiceImpl(DeptDAO dao) {
		super();
		this.dao = dao;
	}
	// 회원가입
	@Override
	public int insert(DeptDTO dept) {
		return dao.insert(dept);
	}
	// 회원 전체 목록 조회

	@Override
	public List<DeptDTO> select() {
		return dao.select();
	}
	@Override
	public int delete(String deptno) {
		return dao.delete(deptno);
	}
	@Override
	public DeptDTO read(String deptno) {
		return dao.read(deptno);
	}
	@Override
	public int update(DeptDTO dept) {
		return dao.update(dept);
	}

}
