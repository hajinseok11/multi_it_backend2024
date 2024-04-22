package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.DBUtil;
import member.MemberDTO;


public class DeptDAOImpl implements DeptDAO{

	@Override
	public int insert(DeptDTO user) {
		System.out.println("=============");
		System.out.println(user); 		// user.toString() 가 생략
		String sql = "insert into mydept values(?,?,?,?)";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result= 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, user.getDeptno());
			ptmt.setString(2, user.getDeptname());
			ptmt.setString(3, user.getTel());
			ptmt.setString(4, user.getAddr());

			result = ptmt.executeUpdate();
			System.out.println(result + "개 행 삽입성공!!");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null,ptmt,con);
		}
		return result;
	}

	@Override
	public int delete(String deptno) {
		Connection con = null;
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("delete mydept where deptcode =? ");
		int result =0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setString(1,deptno);
			result = ptmt.executeUpdate();
			System.out.println(result + "개 행 삭제성공!");		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null,ptmt,con);
		}
		return result;
	}

	@Override
	public List<DeptDTO> select() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from mydept";
		List<DeptDTO> userlist = new ArrayList<>(); // 레코드를 담을 자료구조
		DeptDTO user = null; // 조회한 레코드를 담을 객체
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				user = new DeptDTO(rs.getString("deptcode"),rs.getString("deptname"),rs.getString("tel"),
						rs.getString("addr"));
				userlist.add(user);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,ptmt,con);
		}
		return userlist;
	}	

}
