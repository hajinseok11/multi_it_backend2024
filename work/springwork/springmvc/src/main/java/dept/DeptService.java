package dept;

import java.util.List;

import member.MemberDTO;

public interface DeptService {
	int insert(DeptDTO dept);
	List<DeptDTO> getDeptList();
}
