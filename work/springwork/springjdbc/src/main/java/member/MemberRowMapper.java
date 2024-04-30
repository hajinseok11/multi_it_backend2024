package member;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
/*
 *JdbcTemplate에서 select를 처리하는 query메소드 내부에서 디비에서 조회한 레코드를 어떻게 매핑을 시켜야 하는지
 *정보를 담고있는 객체 
 */
public class MemberRowMapper implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("mapRow=>"+rowNum);
		// while 문안에 정의했던 내용
		MemberDTO user = new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
				rs.getDate(5),rs.getInt(6),rs.getString(7));
		return user;
	}

}
