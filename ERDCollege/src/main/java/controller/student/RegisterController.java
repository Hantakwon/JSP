package controller.student;

import java.io.IOException;

import dto.student.StudentDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.student.StudentService;

@WebServlet("/student/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private StudentService service = StudentService.INSTANCE;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/student/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stdNo = request.getParameter("stdNo");
		String stdName = request.getParameter("stdName");
		String stdHp = request.getParameter("stdHp");
		String stdYear = request.getParameter("stdYear");
		String stdAddress = request.getParameter("stdAddress");
		
		StudentDTO dto = new StudentDTO();
		dto.setStdNo(stdNo);
		dto.setStdName(stdName);
		dto.setStdHp(stdHp);
		dto.setStdYear(Integer.parseInt(stdYear));
		dto.setStdAddress(stdAddress);
		
		service.register(dto);
		
		response.sendRedirect("/ERDCollege/student/list.do");
	}

}
