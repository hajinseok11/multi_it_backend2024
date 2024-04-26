package annotation.basic;
public interface Insa {
	void addUser(MemberDTO user);
	DAO getUser(String id);
	public DAO getDao(); 
	public void setDao(DAO dao);
}

