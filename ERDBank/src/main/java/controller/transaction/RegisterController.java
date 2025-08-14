package controller.transaction;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dto.transaction.TransactionDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.transaction.TransactionService;

@WebServlet("/transaction/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private TransactionService service = TransactionService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/transaction/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String t_no = request.getParameter("t_no");
		String t_a_no= request.getParameter("t_a_no");
		String t_dist = request.getParameter("t_dist");
		String t_amount = request.getParameter("t_amount");
		String t_dateTimeString = request.getParameter("t_dateTime");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate t_dateTimeDate = LocalDate.parse(t_dateTimeString, formatter);

		java.sql.Date t_dateTime = java.sql.Date.valueOf(t_dateTimeDate);

		TransactionDTO dto = new TransactionDTO();
		dto.setT_no(Integer.parseInt(t_no));
		dto.setT_a_no(t_a_no);
		dto.setT_dist(Integer.parseInt(t_dist));
		dto.setT_amount(Integer.parseInt(t_amount));
		dto.setT_dateTime(t_dateTime);
		
		//service.register(dto);
		
		response.sendRedirect("/ERDBank/transaction/list.do");
	}

}
