package fw;

import member.InsertAction;
import product.ProductListAction;

/*
 * FrontServlet이 넘겨준 요청 path를 가지고 실제 실행할 클래스의 객체를 찾아서 리턴하는 작업을 처리
 * => 미리 요청 path별 실행할 실제 클래스를 등록한 설정파일을 보고 찾는다.
 * => xml이나 properties파일이나 annotation으로 등록한 빈이 미리 만들어져서 내부의 Map같은 자료구조에 저장되어 있다.
 * 
 * 그러나 우리는 frontController패턴이 어떻게 동작하는지 보는 것이므로 if else if로 직접 만들어서 리턴
 */
public class RequestMapping {
	public Action mapping(String path) {
		Action action = null;
		// 매개변수로 전달된 path를 이용해서 등록된 객체를 찾아서 리턴하는 코드
		if(path.startsWith("/member/insert.do")) {// InsertAction
			// 해당 path로 등록된 객체를 찾아서 리턴할 수 있도록 코드를 구현해야 하나 우리는 생성해서 전
			action = new InsertAction();			
		} else if (path.startsWith("/product/list.do")) {
			action = new ProductListAction();
		} else if (path.startsWith("/order/order.do")) {
			action = new ProductListAction();
		}
		return action;
	}
		
}
