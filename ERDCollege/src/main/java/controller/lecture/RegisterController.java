package controller.lecture;

import java.io.IOException;

import dto.lecture.LectureDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.lecture.LectureService;

@WebServlet("/lecture/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private LectureService service = LectureService.INSTANCE;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/lecture/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lecNo = request.getParameter("lecNo");
		String lecName= request.getParameter("lecName");
		String lecCredit = request.getParameter("lecCredit");
		String lecTime = request.getParameter("lecTime");
		String lecClass = request.getParameter("lecClass");

		LectureDTO dto = new LectureDTO();
		dto.setLecNo(Integer.parseInt(lecNo));
		dto.setLecName(lecName);
		dto.setLecCredit(Integer.parseInt(lecCredit));
		dto.setLecTime(Integer.parseInt(lecTime));
		dto.setLecClass(lecClass);
		
		service.register(dto);
		
		response.sendRedirect("/ERDCollege/lecture/list.do");
	}

}
