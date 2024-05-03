package member;

import java.util.List;

// member테이블 엑세스
public interface MemberDAO {
	// 회원가입
	int insert(MemberDTO user);
	// 회원정보수정
	int update(MemberDTO updateUserInfo);
	// 회원탈퇴
	int delete(String id);
	// 로그인
	MemberDTO login(String id, String pass);
	// 전체회원목록조회
	List<MemberDTO> select();
	// 회원정보조회
	MemberDTO findById(String id);
	// 주소로검색
	List<MemberDTO> findByAddr(String addr);
	// 전체인원 수 조회
	int count();
}
