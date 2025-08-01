package controller.bank.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.bank.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.bank.CustomerService;

@WebServlet("/bank/customer/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerService service = CustomerService.INSTANCE;
	
    public ListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
		
		customers = service.findAll();
		
		request.setAttribute("customers", customers);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/bank/customer/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
