package controller.register;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.register.RegisterService;

@WebServlet("/register/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private RegisterService service = RegisterService.INSTANCE;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regStdNo = request.getParameter("regStdNo");
		String regLecNo = request.getParameter("regLecNo");
		
		service.remove(regStdNo, Integer.parseInt(regLecNo));
		
		response.sendRedirect("/ERDCollege/register/list.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
