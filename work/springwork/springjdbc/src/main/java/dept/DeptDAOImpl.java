package dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("deptDAO")
public class DeptDAOImpl implements DeptDAO {
	private JdbcTemplate template;
	
	@Autowired
	public DeptDAOImpl(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int insert(DeptDTO dept) {
		System.out.println("insert : "+dept);
		String sql = "insert into mydept (deptcode, deptname, tel, addr)values(?,?,?,?) ";
		return template.update(sql,dept.getDeptCode(),dept.getDeptName(),dept.getTel(),dept.getAddr());
	}

	@Override
	public int update(DeptDTO dept) {
		String sql = "update mydept set tel=?, deptname=? where deptcode =?";
		return template.update(sql,dept.getTel(),dept.getDeptName(),dept.getDeptCode());
	}

	@Override
	public int count() {
		return template.queryForObject("select count(*) from mydept", Integer.class);
	}

	
	@Override
	public DeptDTO getDeptInfo(String deptno) {
		DeptDTO user = null;
		try {
			user = template.queryForObject("select * from mydept where deptcode=?",
					new Object[]{deptno},new DeptRowMapper());
		}catch (EmptyResultDataAccessException e) {
	}return user;
}

	@Override
	public List<DeptDTO> getDeptList() {
		return template.query("select* from mydept", new DeptRowMapper());
	}

	@Override
	public List<DeptDTO> getDeptSearch(String deptname) {
		return template.query("select* from mydept where deptname like ?", 
				new Object[] {"%"+deptname+"%"}, new DeptRowMapper());
	}

	

}
