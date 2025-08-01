package controller.college.student;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.college.StudentService;

@WebServlet("/college/student/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private StudentService service = StudentService.INSTANCE;
	
    public DeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stdno = request.getParameter("stdno");
		
		service.delete(stdno);
		
		response.sendRedirect("/ch10/college/student/list.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
