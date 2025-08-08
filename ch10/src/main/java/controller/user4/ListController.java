package controller.user4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.User4DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User4Service;

@WebServlet("/user4/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private User4Service service = User4Service.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User4DTO> userList = new ArrayList<User4DTO>();
		
		userList = service.findAll();
		
		request.setAttribute("userList", userList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user4/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
