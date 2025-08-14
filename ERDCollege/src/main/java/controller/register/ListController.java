package controller.register;

import java.io.IOException;
import java.util.List;

import dto.register.RegisterDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.register.RegisterService;

@WebServlet("/register/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private RegisterService service = RegisterService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<RegisterDTO> registerList = service.findAll();
		
		request.setAttribute("registerList", registerList);
		
		RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/views/register/list.jsp");
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
