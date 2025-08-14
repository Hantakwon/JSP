package controller.account;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dto.account.AccountDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.account.AccountService;

@WebServlet("/account/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AccountService service = AccountService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a_no = request.getParameter("a_no");
		
		AccountDTO account = service.findById(a_no);
		request.setAttribute("account", account);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/account/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a_no = request.getParameter("a_no");
		String a_item_dist= request.getParameter("a_item_dist");
		String a_item_name = request.getParameter("a_item_name");
		String a_c_no = request.getParameter("a_c_no");
		String a_balance = request.getParameter("a_balance");
		String a_open_dateString = request.getParameter("a_open_date");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate a_open_dateDate = LocalDate.parse(a_open_dateString, formatter);

		java.sql.Date a_open_date = java.sql.Date.valueOf(a_open_dateDate);

		AccountDTO dto = new AccountDTO();
		dto.setA_no(a_no);
		dto.setA_item_dist(a_item_dist);
		dto.setA_item_name(a_item_name);
		dto.setA_c_no(a_c_no);
		dto.setA_balance(Integer.parseInt(a_balance));
		dto.setA_open_date(a_open_date);
		
		service.modify(dto);
		
		response.sendRedirect("/ERDBank/account/list.do");
	}

}
