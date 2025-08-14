package controller.customer;

import java.io.IOException;

import dto.customer.CustomerDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.customer.CustomerService;

@WebServlet("/customer/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService service = CustomerService.INSTANCE;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c_no = request.getParameter("c_no");
		String c_name = request.getParameter("c_name");
		
		CustomerDTO customer = service.findByIdAndName(c_no, c_name);
		
		if(customer != null) {
			HttpSession session = request.getSession();
			session.setAttribute("sessUser", customer);

			response.sendRedirect("/ERDBank/?login=success");
		} else {
			response.sendRedirect("/ERDBank/?login=fail");
		}
	}

}
