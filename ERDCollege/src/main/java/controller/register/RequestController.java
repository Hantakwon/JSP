package controller.register;

import java.io.IOException;

import dto.register.RegisterDTO;
import dto.student.StudentDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.register.RegisterService;

@WebServlet("/register/request.do")
public class RequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private RegisterService service = RegisterService.INSTANCE;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		StudentDTO student = (StudentDTO) session.getAttribute("sessUser");
		String regStdNo = student.getStdNo();
		String regLecNo = request.getParameter("regLecNo");

		RegisterDTO dto = new RegisterDTO();
		dto.setRegStdNo(regStdNo);
		dto.setRegLecNo(Integer.parseInt(regLecNo));
		
		service.register(dto);
		
		response.sendRedirect("/ERDCollege/register/list.do");
	}

}
