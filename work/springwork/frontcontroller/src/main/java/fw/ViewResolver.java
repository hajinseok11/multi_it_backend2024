package fw;

public class ViewResolver {
	public String makeview(String view) {
		// 매개변수로 전달받은 어떤 종류의 뷰를 실행해야 하는지 설정파일을 보고 정보를 리턴하나 우리는 직접 스트링으로 리턴
		return "/views/"+view+".jsp";
	}
}
