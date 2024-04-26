package annotation.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InsaImpl implements Insa {
	
	@Autowired
	@Qualifier("customer")
	DAO dao;
	String msg;
	public InsaImpl() {
		System.out.println("기본생성자 - InsaImpl");
	}
	public InsaImpl(DAO dao) {
		super();
		this.dao = dao;
		System.out.println("매개변수 1개 생성자 - InsaImpl");
	}	
	
	public InsaImpl(DAO dao, String msg) {
		super();
		this.dao = dao;
		this.msg = msg;
		System.out.println("매개변수 2개 생성자 - InsaImpl");
	}
	
	@Override
	public void addUser(MemberDTO user) {
		dao.add(user);		
	}
	@Override
	public DAO getUser(String id) {
		dao.getUser("id");
		return dao;
	}
	public DAO getDao() {
		return dao;
	}
	public void setDao(DAO dao) {
		this.dao = dao;
	}

}
