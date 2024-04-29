package member;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("menu")
public class MenuUI implements AbstractMenu {
	Scanner key = new Scanner(System.in);
	MemberDAO dao;
	@Autowired
	public MenuUI(MemberDAO dao) {
		super();
		this.dao = dao;
	}
	@Override
	public void countMenu() {
		System.out.println("*************사원수 조회하기*************");		
		System.out.println("조회된 레코드 수: " + dao.count());
	}
	public void insertMenu(){
		System.out.println("*******사원등록********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		System.out.print("성명:");
		String name = key.next();
		System.out.print("주소:");
		String addr = key.next();
		System.out.print("기타:");
		String info = key.next();
		MemberDTO user = new MemberDTO(id, pass, name, addr, info);
		int result = dao.insert(user);
		if(result>=1) {
			System.out.println("=========================");
			System.out.println("로그인해서 메인페이지 이동");
			System.out.println("=========================");
		}else {
			System.out.println("--------------------------");
			System.out.println("실패를 알려 줄 수 있는 alert실행");
			System.out.println("다시 회원가입할 수 있는 페이지로 이동");
			System.out.println("--------------------------");
		}
	}
	public void updateMenu(){
		System.out.println("*******사원수정********");
		System.out.print("정보:");
		String info = key.next();
		System.out.print("주소:");
		String addr = key.next();
		System.out.print("아이디:");
		String id = key.next();

		MemberDTO updateUser = new MemberDTO(id, addr, info);
		int result = dao.update(updateUser);
		System.out.println(result+"개 수정완료");
	}
	public void deleteMenu(){
		System.out.println("*******사원삭제********");
		System.out.print("삭제할id:");
		String id = key.next();
		int result = dao.delete(id);
		System.out.println(result + "개 삭제완료");
	}
	public void findByAddrMenu(){
		System.out.println("*******사원검색********");
		System.out.print("주소:");
		String addr = key.next();
		List<MemberDTO> searchlist =  dao.findByAddr(addr);
		for(MemberDTO user:searchlist) {
			print(user);
		}
	}
	public void loginMenu() {
		System.out.println("*******로그인********");
		System.out.print("아이디:");
		String id = key.next();
		System.out.print("패스워드:");
		String pass = key.next();
		MemberDTO loginUser =  dao.login(id, pass);
		if(loginUser!=null) {
			System.out.println("로그인성공");
			print(loginUser);
		}else {
			System.out.println("로그인실패");
		}
	}
	public void selectMenu(){
		System.out.println("*******사원조회********");
		List<MemberDTO> userlist =  dao.select();
		System.out.println("조회된 레코드 갯수:"+userlist.size());
		for(MemberDTO user:userlist) {
			print(user);
		}
	}
	public void myPageMenu() {
		System.out.println("*******마이페이지********");
		System.out.print("아이디:");
		String id = key.next();
		MemberDTO user=  dao.findById(id);
		if(user==null) {
			System.out.println("일치하는 사용자가 없습니다.");
		}else {
			print(user);
		}
	}
	public void print(MemberDTO user) {
		System.out.print(user.getId()+"\t");
		System.out.print(user.getPass()+"\t");
		System.out.print(user.getName()+"\t");
		System.out.print(user.getAddr()+"\t");
		System.out.print(user.getRegDate()+"\t");
		System.out.print(user.getPoint()+"\t");
		System.out.println(user.getInfo()+"\t");
	}
}













