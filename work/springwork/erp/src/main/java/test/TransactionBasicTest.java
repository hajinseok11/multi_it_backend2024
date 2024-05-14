package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionBasicTest {
	public static void main(String[] args) {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "erp";
			String password = "erp";
			String sql ="";
			Connection con =null;
			PreparedStatement ptmt =null;
			boolean state = false;
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(url, user, password);
				// con.setAutoCommit(false)로 정의하면 여기서 부터 하나의 트랜잭션으로 처리가 된다.
				con.setAutoCommit(false);
				sql = "insert into test values('4444','111','111','111',1000,'111','002')";
				ptmt = con.prepareStatement(sql);
				ptmt.executeUpdate();
				
				sql = "insert into test values('5555','222','222','222',1000,'222','002')";
				ptmt = con.prepareStatement(sql);
				ptmt.executeUpdate();
			
				sql = "insert into test values('6666','333','333','333',1000,'333','002'";
				ptmt = con.prepareStatement(sql);
				ptmt.executeUpdate();
				state=true;
				
				System.out.println("처리완료");
			}catch(ClassNotFoundException e){
				System.out.println("오류발생");
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				try{
					if(state) {// 정상처리상태
						con.commit();
				}else {
					con.rollback();// 모든 작업을 취소
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}		
	
