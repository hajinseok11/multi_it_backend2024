package dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDAOImpl implements DeptDAO{
	private JdbcTemplate template;
	
	@Autowired
	public DeptDAOImpl(JdbcTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public int insert(DeptDTO dept) {
		System.out.println("insert:"+dept);
		String sql = "insert into mydept values(?,?,?,?)";
		return template.update(sql,dept.getDeptCode(),dept.getDeptName(),dept.getTel(),dept.getAddr());
	}

	@Override
	public int update(DeptDTO dept) {
		String sql = "update mydept set tel=?,addr=? where deptcode=?";
		return template.update(sql,dept.getTel(),dept.getAddr(),dept.getDeptCode());
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return template.queryForObject("select count(*) from mydept", Integer.class);
	}

	@Override
	public DeptDTO getDeptInfo(String deptno) {
		DeptDTO dept = null;
		try {
			dept = template.queryForObject("select * from mydept where deptcode = ?", 
						new Object[] {deptno}, new DeptRowMapper());
		}catch (EmptyResultDataAccessException  e) {
		}
		return dept;
	}

	@Override
	public List<DeptDTO> getDeptList() {
		return template.query("select * from mydept", new DeptRowMapper());
	}

	@Override
	public List<DeptDTO> getDeptSearch(String deptname) {
		// TODO Auto-generated method stub
//		String sql1 = "";
//		String sql2 = "";
//		String sql3 = "";
//		if(deptname.contains("영업")) {
//			//sql1을 사용
//		}else if(deptname.contains("전산")) {
//			//sql2을 사용
//		}else {
//			//sql3을 사용
//		}
		return template.query("select * from mydept where deptname like ?", new Object[] {"%"+deptname+"%"},
					new DeptRowMapper());
	}

}






