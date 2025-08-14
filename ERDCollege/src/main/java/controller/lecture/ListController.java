package controller.lecture;

import java.io.IOException;
import java.util.List;

import dto.lecture.LectureDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.lecture.LectureService;

@WebServlet("/lecture/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LectureService service = LectureService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<LectureDTO> lectureList = service.findAll();
		
		request.setAttribute("lectureList", lectureList);
		
		RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/views/lecture/list.jsp");
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
