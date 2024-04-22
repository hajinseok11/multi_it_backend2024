package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


// insert, delete, update, select login, search
public class MemberDAOImpl implements MemberDAO{
	
	public int insert(MemberDTO user) {
		System.out.println("=============");
		System.out.println(user); 		// user.toString() 가 생략
		String sql = "insert into member values(?,?,?,?,sysdate,20000,?)";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result= 0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, user.getId());
			ptmt.setString(2, user.getPass());
			ptmt.setString(3, user.getName());
			ptmt.setString(4, user.getAddr());
			ptmt.setString(5, user.getInfo());
			result = ptmt.executeUpdate();
			System.out.println(result + "개 행 삽입성공!!");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null,ptmt,con);
		}
		return result;
	}
	
	public List<MemberDTO> select() {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		List<MemberDTO> userlist = new ArrayList<>(); // 레코드를 담을 자료구조
		MemberDTO user = null; // 조회한 레코드를 담을 객체
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				// 레코드의 한 컬럼들을 이용해서 MemberDTO객체를 생성
				user = new MemberDTO(rs.getString("id"),rs.getString("pass"),rs.getString("name"),
						rs.getString(4),rs.getDate(5),rs.getInt("point"),rs.getString(7));
				userlist.add(user);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,ptmt,con);
		}
		return userlist;
	}
	public int delete(String id) {
		Connection con = null;
		PreparedStatement ptmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("delete member where id =? ");
		int result =0;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql.toString());
			ptmt.setString(1,id);
			result = ptmt.executeUpdate();
			System.out.println(result + "개 행 삭제성공!");		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null,ptmt,con);
		}
		return result;
	}
	public MemberDTO login(String id, String pass) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		MemberDTO loginUser = null;
		String sql = "select * from member where id = ? and pass = ?";
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			rs = ptmt.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				loginUser = new MemberDTO(rs.getString("id"),rs.getString("pass"),rs.getString("name"),
						rs.getString(4),rs.getDate(5),rs.getInt("point"),rs.getString(7));
				System.out.println(rs.getString("name")+"님 로그인 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,ptmt,con);
		}
		return loginUser;
	}

	@Override
	public List<MemberDTO> findByAddr(String addr) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from member where ADDR like ?";
		List<MemberDTO> userlist = new ArrayList<>(); // 레코드를 담을 자료구조
		MemberDTO user = null; // 조회한 레코드를 담을 객체
	try {
		con = DBUtil.getConnect();
		ptmt = con.prepareStatement(sql);
		ptmt.setString(1, addr);
		rs = ptmt.executeQuery();
		System.out.println(rs);
		while(rs.next()) {
			// 레코드의 한 컬럼들을 이용해서 MemberDTO객체를 생성
			user = new MemberDTO(rs.getString("id"),rs.getString("pass"),rs.getString("name"),
					rs.getString(4),rs.getDate(5),rs.getInt("point"),rs.getString(7));
			userlist.add(user);
		}
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBUtil.close(rs,ptmt,con);
	}
	return userlist;
	}

	@Override
	public List<MemberDTO> findById(String id) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id like ?";
		List<MemberDTO> userlist = new ArrayList<>(); // 레코드를 담을 자료구조
		MemberDTO user = null; // 조회한 레코드를 담을 객체
	try {
		con = DBUtil.getConnect();
		ptmt = con.prepareStatement(sql);
		ptmt.setString(1, id);
		rs = ptmt.executeQuery();
		System.out.println(rs);
		while(rs.next()) {
			// 레코드의 한 컬럼들을 이용해서 MemberDTO객체를 생성
			user = new MemberDTO(rs.getString("id"),rs.getString("pass"),rs.getString("name"),
					rs.getString(4),rs.getDate(5),rs.getInt("point"),rs.getString(7));
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

