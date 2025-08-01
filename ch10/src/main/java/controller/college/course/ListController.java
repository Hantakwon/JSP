package controller.college.course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.college.CourseDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.college.CourseService;

@WebServlet("/college/course/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CourseService service = CourseService.INSTANCE;
	
    public ListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CourseDTO> courses = new ArrayList<CourseDTO>();
		
		courses = service.findAll();
		
		request.setAttribute("courses", courses);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/college/course/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
