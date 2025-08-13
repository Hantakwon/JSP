package controller.customer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dto.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CustomerService;

@WebServlet("/customer/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerService service = CustomerService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String custId = request.getParameter("custId");
		
		CustomerDTO customer = service.findById(custId);
		request.setAttribute("customer", customer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custId = request.getParameter("custId");
		String name = request.getParameter("name");
		String hp = request.getParameter("hp");
		String addr = request.getParameter("addr");
		String rdateString = request.getParameter("rdate");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate rdateDate = LocalDate.parse(rdateString, formatter);

		java.sql.Date rdate = java.sql.Date.valueOf(rdateDate);

		CustomerDTO dto = new CustomerDTO();
		dto.setCustId(custId);
		dto.setName(name);
		dto.setHp(hp);
		dto.setAddr(addr);
		dto.setRdate(rdate);
		
		service.modify(dto);
		
		response.sendRedirect("/shopApp/customer/list.do");
	}

}
