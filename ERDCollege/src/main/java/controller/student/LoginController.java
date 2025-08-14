package controller.student;

import java.io.IOException;

import dto.student.StudentDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.student.StudentService;

@WebServlet("/student/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentService service = StudentService.INSTANCE;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stdNo = request.getParameter("stdNo");
		String stdName = request.getParameter("stdName");
		
		StudentDTO student = service.findByIdAndName(stdNo, stdName);
		
		if(student != null) {
			HttpSession session = request.getSession();
			session.setAttribute("sessUser", student);

			response.sendRedirect("/ERDCollege/?login=success");
		} else {
			response.sendRedirect("/ERDCollege/?login=fail");
		}
	}

}
