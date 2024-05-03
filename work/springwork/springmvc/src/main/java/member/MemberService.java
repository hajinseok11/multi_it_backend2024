package member;

import java.util.List;

public interface MemberService {
	int insert(MemberDTO user);
	List<MemberDTO> getMemberList();
}
