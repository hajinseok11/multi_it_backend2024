package dept;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeptRowMapper implements RowMapper<DeptDTO>{

	@Override
	public DeptDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new DeptDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
	}

}
