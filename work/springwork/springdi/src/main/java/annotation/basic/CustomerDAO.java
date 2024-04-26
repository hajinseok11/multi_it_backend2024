package annotation.basic;

import org.springframework.stereotype.Component;

@Component("customer")
public class CustomerDAO implements DAO {
	public CustomerDAO() {
		System.out.println("CustomerDAO의 기본생성자");
	}
	
	@Override
	public void add(MemberDTO user) {
		System.out.println("CustomerDAO의 add");

	}

	@Override
	public MemberDTO getUser(String id) {
		System.out.println("CustomerDAO의 getUser");
		return null;
	}

}
