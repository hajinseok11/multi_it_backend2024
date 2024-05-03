package tiles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// tiles기반으로 요청
@Controller
public class TilesController {
	@RequestMapping("/index")
	public String index() {
		System.out.println("tiles를 활용한 뷰 생성");
		return "tiles/index"; // 컨트롤러에서 리턴하는 뷰의 이름은 tiles 설정파일에서 등록한 <definition>엘리먼트의
							  // name 속성으로 등록한 이름
	}
	@RequestMapping("/tiles/insert")
	public String insertPage() {
		return "tiles/insert";
	}
	@RequestMapping("/tiles/login")
	public String loginPage() {
		return "tiles/login";
	}
	
}
