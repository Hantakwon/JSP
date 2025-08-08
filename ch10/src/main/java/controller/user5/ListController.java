package controller.user5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.User5DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User5Service;

@WebServlet("/user5/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private User5Service service = User5Service.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User5DTO> userList = new ArrayList<User5DTO>();
		
		userList = service.findAll();
		
		request.setAttribute("userList", userList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user5/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
