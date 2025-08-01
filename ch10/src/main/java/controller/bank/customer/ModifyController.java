package controller.bank.customer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dto.bank.AccountDTO;
import dto.bank.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.bank.CustomerService;

@WebServlet("/bank/customer/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerService service = CustomerService.INSTANCE;
	
    public ModifyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String c_id = request.getParameter("c_id");
		
		CustomerDTO customer = service.findById(c_id);
		
		System.out.println(customer);
		
		request.setAttribute("customer", customer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/bank/customer/modify.jsp");
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
		
		service.modify(dto);
		
		response.sendRedirect("/ch10/bank/customer/list.do");
	}

}
