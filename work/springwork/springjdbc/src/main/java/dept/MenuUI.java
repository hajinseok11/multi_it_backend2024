package dept;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.MemberDTO;
@Service("menu")
public class MenuUI implements AbstractUI {
	DeptDAO dao;
	public MenuUI() {
		
	}
	@Autowired
	public MenuUI(DeptDAO dao) {
		this.dao = dao;
	}
	Scanner key = new Scanner(System.in);
	//시작을 알리는 메소드
	public void show(){
		System.out.println("**********부서관리 시스템************");
		System.out.println("1. 부서등록");
		System.out.println("2. 부서상세보기");
		System.out.println("3. 부서정보수정(부서번호)");
		System.out.println("4. 부서삭제");
		System.out.println("5. 전체 부서 목록보기");
		System.out.println("6. 부서검색(부서명)");
		System.out.println("7. 부서갯수조회");
		System.out.println("8. 각 부서별 근무직원 조회하기(부서명)");
		System.out.println("9. 종료");
		System.out.print("원하는 작업을 선택하세요:");
		int menu=key.nextInt();
		menuSelect(menu);
	}
	private void menuSelect(int menu) {
		switch(menu){
			case 1:
				insertMenu();
				break;
			case 2:
				showDeptInfo();
				break;
			case 3:
				updateMenu();
				break;
			case 5:
				showAllMenu();
				break;
			case 6:
				findByDept();
				break;
			case 7:
				countMenu();
				break;
			case 9:
				System.exit(0);//프로그램 정상종료
	}
	}
	@Override
	public void countMenu() {
			System.out.println("*************부서수 조회하기*************");		
			System.out.println("조회된 레코드 수: " + dao.count());
	}
	@Override
	public void insertMenu() {
		System.out.println("*******부서등록********");
		System.out.print("부서코드:");
		String deptCode = key.next();
		System.out.print("부서이름:");
		String deptName = key.next();
		System.out.print("전화번호:");
		String tel = key.next();
		System.out.print("주소:");
		String addr = key.next();

		DeptDTO dept = new DeptDTO(deptCode, deptName, tel, addr);
		int result = dao.insert(dept);
		
		System.out.println(result+" 개 부서 삽입완료");
		
	}
	@Override
	public void updateMenu() {
		System.out.println("*******부서수정********");
		System.out.print("부서코드:");
		String deptcode = key.next();
		System.out.print("부서명:");
		String deptname = key.next();
		System.out.print("전화번호:");
		String tel = key.next();

		DeptDTO updateUser = new DeptDTO(deptcode,deptname,tel);
		int result = dao.update(updateUser);
		System.out.println(result+"개 수정완료");
		
	}
	@Override
	public void deleteMenu() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showAllMenu() {
		//전체부서 목록조회
		List<DeptDTO> deptlist = dao.getDeptList();
		for(DeptDTO dept : deptlist) {
			print(dept);
		}
	}
	@Override
	public void showDeptInfo() {
		System.out.print("부서코드:");
		String deptcode = key.next();
		DeptDTO dept = dao.getDeptInfo(deptcode);
		if(dept==null) {
			System.out.println("부서코드 다시 입력");
		}else {
			print(dept);
		}
	}
	@Override
	public void findByDept() {
		System.out.print("부서명:");
		String deptname = key.next();
		List<DeptDTO> deptlist = dao.getDeptSearch(deptname);
		for(DeptDTO dept:deptlist) {
			print(dept);
		}
		
	}
	@Override
	public void getMemberList() {
		// TODO Auto-generated method stub
		
	}
	public void print(DeptDTO dept) {
		System.out.print(dept.getDeptCode()+"\t");
		System.out.print(dept.getDeptName()+"\t");
		System.out.print(dept.getTel()+"\t");
		System.out.print(dept.getAddr()+"\t");

	}
	
}








