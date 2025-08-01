package controller.bank.customer;

import java.io.IOException;

import dto.bank.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.bank.AccountService;
import service.bank.CustomerService;

@WebServlet("/bank/customer/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private CustomerService service = CustomerService.INSTANCE;
		
    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/bank/customer/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c_id = request.getParameter("c_id");
		String c_name = request.getParameter("c_name");
		String c_type = request.getParameter("c_type");
		String c_hp = request.getParameter("c_hp");
		String c_addr = request.getParameter("c_addr");

		CustomerDTO dto = new CustomerDTO();
		dto.setC_id(c_id);
		dto.setC_name(c_name);
		dto.setC_type(Integer.parseInt(c_type));
		dto.setC_hp(c_hp);
		dto.setC_addr(c_addr);
		
		service.register(dto);
		
		response.sendRedirect("/ch10/bank/customer/list.do");
	}

}
