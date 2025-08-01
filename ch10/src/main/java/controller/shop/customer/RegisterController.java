package controller.shop.customer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.shop.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.CustomerService;

@WebServlet("/shop/customer/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private CustomerService service = CustomerService.INSTANCE;
	
	// 로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/shop/customer/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cid = request.getParameter("cid");
		String name = request.getParameter("name");
		String hp = request.getParameter("hp");
		String address = request.getParameter("address");
		String rdate = request.getParameter("rdate");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqlDate = null; 

		try {
		    Date utilDate = format.parse(rdate);
		    sqlDate = new java.sql.Date(utilDate.getTime());
		    
		} catch (ParseException e) {
		    e.printStackTrace();
		}

		CustomerDTO dto = new CustomerDTO();
		dto.setCid(cid);
		dto.setName(name);
		dto.setHp(hp);
		dto.setAddress(address);
		dto.setRdate(sqlDate);
	
		logger.info(dto.toString());
		
		service.register(dto);
		
		response.sendRedirect("/ch10/shop/customer/list.do");
	}

}
