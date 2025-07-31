package controller.user6;

import java.io.IOException;
import java.util.List;

import dto.User6DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User6Service;

@WebServlet("/user6/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private User6Service service = User6Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 조회
		List<User6DTO> userList = service.findAll();
		
		// request 객체로 데이터 공유
		req.setAttribute("userList", userList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user6/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
