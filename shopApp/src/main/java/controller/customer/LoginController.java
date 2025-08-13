package controller.customer;

import java.io.IOException;

import dto.CustomerDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CustomerService;

@WebServlet("/customer/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerService service = CustomerService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custId = request.getParameter("custId");
		
		CustomerDTO sessUser = service.findById(custId);
		
		if(sessUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("sessUser", sessUser);

			response.sendRedirect("/shopApp/product/list.do?login=success");
		} else {
			response.sendRedirect("/shopApp/product/list.do?login=fail");
		}
	}
}
