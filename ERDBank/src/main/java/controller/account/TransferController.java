package controller.account;

import java.io.IOException;

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

@WebServlet("/account/transfer.do")
public class TransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private CustomerService customerService = CustomerService.INSTANCE;
	private TransactionService transactionService = TransactionService.INSTANCE; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerDTO sessUser = (CustomerDTO) session.getAttribute("sessUser");
		CustomerDTO customer = customerService.findById(sessUser.getC_no());
		
		request.setAttribute("customer", customer);
		
		RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/views/account/transfer.jsp");
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a_no_from = request.getParameter("a_no_from");
		String a_no_to = request.getParameter("a_no_to");
		// String a_c_name = request.getParameter("a_c_name");
		String a_amount = request.getParameter("a_amount");
		
		// 출금
		TransactionDTO transaction = new TransactionDTO();
		transaction.setT_a_no(a_no_from);
		transaction.setT_a_no_to(a_no_to);
		transaction.setT_amount(Integer.parseInt(a_amount));
		transaction.setT_dist(3);
		transactionService.transfer(transaction);
		
		response.sendRedirect("/ERDBank/account/list.do?transfer=done");
	}

}
