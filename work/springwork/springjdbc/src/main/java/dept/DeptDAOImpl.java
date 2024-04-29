package dept;

import org.springframework.beans.factory.annotation.Autowired;
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
		String sql = "update mydept set tel=?, addr=? where deptcode =?";
		return template.update(sql,dept.getTel(),dept.getAddr(),dept.getDeptCode());
	}

	@Override
	public int count() {
		return template.queryForObject("select count(*) from mydept", Integer.class);
	}

}
