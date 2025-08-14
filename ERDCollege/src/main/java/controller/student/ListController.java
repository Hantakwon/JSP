package controller.student;

import java.io.IOException;
import java.util.List;

import dto.student.StudentDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.student.StudentService;

@WebServlet("/student/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private StudentService service = StudentService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<StudentDTO> studentList = service.findAll();
		
		request.setAttribute("studentList", studentList);
		
		RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/views/student/list.jsp");
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
