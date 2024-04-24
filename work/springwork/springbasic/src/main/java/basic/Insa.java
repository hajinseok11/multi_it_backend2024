package basic;
public interface Insa {
	void addUser(MemberDTO user);
	MemberDTO getUser(String id);
	public MemberDAO getDao(); 
	public void setDao(MemberDAO dao);
}

