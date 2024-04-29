package first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HrDAO {
	// Spring에서 제공하는 JdbcTemplate의 기능을 이용해서 DB연동
	private JdbcTemplate template;
	// 스프링컨테이너가 매개변수 있는 생성자를 호출하면서 객체를 생성
	// => 객체 생성할 때 매개변수에 해당하는 빈이 있는지 타입을 검사해서 있으면 주입해서 생성한다.
	@Autowired
	public HrDAO(JdbcTemplate template) {
		super();
		this.template = template;
	}
	// hr계정의 jobs테이블의 레코드 수를 리턴하는 메소드를 정의
	// select count(*) from jobs
	public int count() {
		return template.queryForObject("select count(*) from jobs", Integer.class);
	}

}


