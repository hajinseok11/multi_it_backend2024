package fw;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	String run(HttpServletRequest request, HttpServletResponse response)
															throws ServerException, IOException;
}
