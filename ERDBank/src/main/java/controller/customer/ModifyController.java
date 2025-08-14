package controller.customer;

import java.io.IOException;

import dto.customer.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.customer.CustomerService;

@WebServlet("/customer/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerService service = CustomerService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c_no = request.getParameter("c_no");
		
		CustomerDTO customer = service.findById(c_no);
		request.setAttribute("customer", customer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c_no = request.getParameter("c_no");
		String c_name= request.getParameter("c_name");
		String c_dist = request.getParameter("c_dist");
		String c_phone = request.getParameter("c_phone");
		String c_addr = request.getParameter("c_addr");

		CustomerDTO dto = new CustomerDTO();
		dto.setC_no(c_no);
		dto.setC_name(c_name);
		dto.setC_dist(Integer.parseInt(c_dist));
		dto.setC_phone(c_phone);
		dto.setC_addr(c_addr);
		
		service.modify(dto);
		
		response.sendRedirect("/ERDBank/customer/list.do");
	}

}
