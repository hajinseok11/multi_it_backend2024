package member;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class DAOTest {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("******인사관리시스템********");
		System.out.println("1. 사원등록");
		System.out.println("2. 전체사원조회");
		System.out.println("3. 사원수정");
		System.out.println("4. 사원퇴사");
		System.out.println("5. 주소로 사원 검색");
		System.out.println("6. 로그인");
		System.out.println("7. 사원정보조회");
		System.out.println("8. 인원수 조회");
		System.out.print("원하는 작업을 선택하세요:");
		int choice  = key.nextInt();
		show(choice);
	}
	public static void show(int choice){
		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/member.xml");
		AbstractMenu ui = factory.getBean("menu",AbstractMenu.class);
		switch(choice){
			case 1:
				ui.insertMenu();
				break;
			case 2:
				ui.selectMenu();
				break;
			case 3:
				ui.updateMenu();
				break;
			case 4:
				ui.deleteMenu();
				break;
			case 5:
				ui.findByAddrMenu();
				break;
			case 6:
				ui.loginMenu();
				break;
			case 7:
				ui.myPageMenu();
				break;
			case 8:
				ui.countMenu();
				break;
				
		}
	}
}
