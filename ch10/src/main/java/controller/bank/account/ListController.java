package controller.bank.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.bank.AccountDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.bank.AccountService;

@WebServlet("/bank/account/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private AccountService service = AccountService.INSTANCE;
	
    public ListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<AccountDTO> accounts = new ArrayList<AccountDTO>();
		
		accounts = service.findAll();
		
		request.setAttribute("accounts", accounts);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/bank/account/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
