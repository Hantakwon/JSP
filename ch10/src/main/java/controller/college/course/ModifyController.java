package controller.college.course;

import java.io.IOException;

import dto.college.CourseDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.college.CourseService;

@WebServlet("/college/course/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CourseService service = CourseService.INSTANCE;
	
    public ModifyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cs_id = request.getParameter("cs_id");
		
		CourseDTO course = service.findById(Integer.parseInt(cs_id));
		
		request.setAttribute("course", course);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/college/course/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cs_id = request.getParameter("cs_id");
		String cs_name = request.getParameter("cs_name");
		String cs_credit = request.getParameter("cs_credit");
		String cs_dept = request.getParameter("cs_dept");

		CourseDTO dto = new CourseDTO();
		dto.setCs_id(Integer.parseInt(cs_id));
		dto.setCs_name(cs_name);
		dto.setCs_credit(Integer.parseInt(cs_credit));
		dto.setCs_dept(cs_dept);

		service.modify(dto);
		
		response.sendRedirect("/ch10/college/course/list.do");
	}

}
