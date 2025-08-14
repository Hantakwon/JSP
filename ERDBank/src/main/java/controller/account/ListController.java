package controller.account;

import java.io.IOException;
import java.util.List;

import dto.account.AccountDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.account.AccountService;

@WebServlet("/account/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AccountService service = AccountService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AccountDTO> accountList = service.findAll();
		
		request.setAttribute("accountList", accountList);
		
		RequestDispatcher dispather = request.getRequestDispatcher("/WEB-INF/views/account/list.jsp");
		dispather.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
