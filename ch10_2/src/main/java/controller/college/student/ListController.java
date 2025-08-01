package controller.college.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.college.StudentDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.college.StudentService;

@WebServlet("/college/student/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentService service = StudentService.INSTANCE;
	
    public ListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<StudentDTO> students = new ArrayList<StudentDTO>();
		
		students = service.findAll();
		
		request.setAttribute("students", students);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/college/student/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
