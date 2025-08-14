package controller.transaction;

import java.io.IOException;
import java.util.List;

import dto.transaction.TransactionDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.transaction.TransactionService;

@WebServlet("/transaction/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TransactionService service = TransactionService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TransactionDTO> transactionList = service.findAll();
		
		request.setAttribute("transactionList", transactionList);
		
		RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/views/transaction/list.jsp");
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
