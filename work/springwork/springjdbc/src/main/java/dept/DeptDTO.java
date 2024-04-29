package dept;
public class DeptDTO {
	String deptCode;
	String deptName;
	String tel;
	String addr;
	
	public DeptDTO(){
		
	}
	public DeptDTO(String deptCode, String deptName, String tel, String addr) {
		super();
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.tel = tel;
		this.addr = addr;
	}
	
	public DeptDTO(String deptCode, String tel, String addr) {
		super();
		this.deptCode = deptCode;
		this.tel = tel;
		this.addr = addr;
	}
	public DeptDTO(String tel2, String addr2) {

	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "DeptDTO [deptCode=" + deptCode + ", deptName=" + deptName + ", tel=" + tel + ", addr=" + addr + "]";
	}
	
	
}
