package controller.account;

import java.io.IOException;
import java.util.List;

import dto.customer.CustomerDTO;
import dto.transaction.TransactionDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.customer.CustomerService;
import service.transaction.TransactionService;

@WebServlet("/account/show.do")
public class ShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TransactionService transactionService = TransactionService.INSTANCE;
	private CustomerService customerService = CustomerService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerDTO sessUser = (CustomerDTO) session.getAttribute("sessUser");
		CustomerDTO customer = customerService.findById(sessUser.getC_no());
		
		List<TransactionDTO> transactionList = transactionService.findByTANO(customer.getC_a_no());
		
		request.setAttribute("transactionList", transactionList);
		
		RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/views/account/show.jsp");
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
