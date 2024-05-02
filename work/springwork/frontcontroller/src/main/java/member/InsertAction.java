package member;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fw.Action;

public class InsertAction implements Action {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		System.out.println("회원가입기능처리");
		return "insert";
	}

}
