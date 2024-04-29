package dept;

public interface DeptDAO {
	//부서상세보기 - 부서번호로 부서의 정보를 조회 - 필수
	//DeptDTO getDeptInfo(String deptno);
	//전체 부서의 목록 보기 - 필수
	//List<DeptDTO> getDeptList();
	//부서검색 - 필수
	//List<DeptDTO> getDeptSearch(String deptname);
	//부서등록
	int insert(DeptDTO dept);
	//부서업데이트 - 부서의 전화번호와 주소를 수정하도롥
	int update(DeptDTO dept);
	
	//총부서갯수
	int count();
	
}
