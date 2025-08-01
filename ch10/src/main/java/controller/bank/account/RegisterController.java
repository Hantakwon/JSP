package controller.bank.account;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dto.bank.AccountDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.bank.AccountService;

@WebServlet("/bank/account/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private AccountService service = AccountService.INSTANCE;
		
    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/bank/account/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acc_no = request.getParameter("acc_no");
		String acc_type = request.getParameter("acc_type");
		String acc_name = request.getParameter("acc_name");
		String acc_cid = request.getParameter("acc_cid");
		String acc_balance = request.getParameter("acc_balance");
		String acc_dateString = request.getParameter("acc_date");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date acc_date = null; 
		
		try {
		    Date acc_dateDate = format.parse(acc_dateString);
		    
		    acc_date = new java.sql.Date(acc_dateDate.getTime());
		    
		} catch (ParseException e) {
		    e.printStackTrace();
		}

		AccountDTO dto = new AccountDTO();
		dto.setAcc_no(acc_no);
		dto.setAcc_type(acc_type);
		dto.setAcc_name(acc_name);
		dto.setAcc_cid(acc_cid);
		dto.setAcc_balance(Integer.parseInt(acc_balance));
		dto.setAcc_date(acc_date);

		service.register(dto);
		
		response.sendRedirect("/ch10/bank/account/list.do");
	}

}
