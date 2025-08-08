package controller.user1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.User1DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User1Service;

@WebServlet("/user1/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private User1Service service = User1Service.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User1DTO> userList = new ArrayList<User1DTO>();
		
		userList = service.findAll();
		
		request.setAttribute("userList", userList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user1/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
