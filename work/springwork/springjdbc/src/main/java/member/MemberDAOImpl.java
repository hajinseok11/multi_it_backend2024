package member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	private JdbcTemplate template;
	@Autowired
	public MemberDAOImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}
	
	public int count() {
		return template.queryForObject("select count(*) from member", Integer.class);
	}

	@Override
	public int insert(MemberDTO user) {
		String sql = "insert into member values(?,?,?,?,sysdate,10000,?)";
		// JdbcTemplate의 update메소드를 호출해서 db에 insert하는 작업을 수행
		// sql문과 ?에 대한 값을 매개변수로 전달
		// sql문을 정의하고 ?에 셋팅할 값을 순서대로 지정
		// id, pass,name,addr,,,info
		return template.update(sql,user.getId(),user.getPass(),user.getName(),user.getAddr(),user.getInfo());
	}

	@Override
	public int update(MemberDTO updateUserInfo) {
		String sql = "update member set addr =?,info=? where id =?";
		// id가 만족하는 데이터의 주소와 정보를 수정할 수 있도록 처리
		return template.update(sql,updateUserInfo.getAddr(),updateUserInfo.getInfo(),updateUserInfo.getId());
	}

	@Override
	public int delete(String id) {
		String sql = "delete from member where id = ?";
		// 입력받은 아이디에 해당하는 레코드를 삭제 
		return template.update(sql,id);
	}

	@Override
	public MemberDTO login(String id, String pass) {		
		MemberDTO user = null;
		try {
			user = template.queryForObject("select * from member where id =? and pass = ?",
				new Object[] {id,pass}, new MemberRowMapper());
		}catch (EmptyResultDataAccessException e) {
			
		}
		return user;
	}

	@Override
	public List<MemberDTO> select() {
		return template.query("select * from member", new MemberRowMapper());
	}

	@Override
	public MemberDTO findById(String id) {
		MemberDTO user = null;
		try {
			user = template.queryForObject("select * from member where id = ?", 
				new Object[] {id}, new MemberRowMapper());
		}catch (EmptyResultDataAccessException e) {
			
		}
		return user;
	}

	@Override
	public List<MemberDTO> findByAddr(String addr) {
		return template.query("select * from member where addr like ?", 
				new Object[]{"%"+addr+"%"}, new MemberRowMapper());
	}
}
