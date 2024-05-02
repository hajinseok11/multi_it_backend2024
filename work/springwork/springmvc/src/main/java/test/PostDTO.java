package test;

public class PostDTO {
	String userId;
	String userName;
	String passwd;
	String nickname;
	String gender;
	String job;
	public PostDTO() {
		System.out.println("기본생성자 -PostDTO");
	}
	public PostDTO(String userId, String userName, String passwd, String nickname, String gender, String job) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passwd = passwd;
		this.nickname = nickname;
		this.gender = gender;
		this.job = job;
	}
	@Override
	public String toString() {
		return "PostDTO [userId=" + userId + ", userName=" + userName + ", passwd=" + passwd + ", nickname=" + nickname
				+ ", gender=" + gender + ", job=" + job + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	
	
}
