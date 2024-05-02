package product;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fw.Action;

public class ProductListAction implements Action{

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		System.out.println("상품조회기능");
		return "list";
	}

}
