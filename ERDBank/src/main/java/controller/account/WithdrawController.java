package controller.account;

import java.io.IOException;

import dto.account.AccountDTO;
import dto.customer.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.account.AccountService;
import service.customer.CustomerService;

@WebServlet("/account/withdraw.do")
public class WithdrawController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AccountService accountService = AccountService.INSTANCE;
	private CustomerService customerService = CustomerService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerDTO sessUser = (CustomerDTO) session.getAttribute("sessUser");
		CustomerDTO customer = customerService.findById(sessUser.getC_no());
		
		request.setAttribute("customer", customer);
		
		RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/views/account/withdraw.jsp");
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a_no = request.getParameter("a_no");
		String a_amount = request.getParameter("a_amount");
		
		AccountDTO account = accountService.findById(a_no);
		account.setA_balance(account.getA_balance() - Integer.parseInt(a_amount));
		
		accountService.modify(account);
		
		response.sendRedirect("/ERDBank/account/list.do");
	}

}
