package controller.shop.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.CustomerService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dto.shop.CustomerDTO;

@WebServlet("/shop/customer/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerService service = CustomerService.INSTANCE;
	
    public ModifyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cid = request.getParameter("cid");
		
		CustomerDTO customer = service.findById(cid);
		
		request.setAttribute("customer", customer);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/shop/customer/modify.jsp");
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
		
		service.modify(dto);
		
		response.sendRedirect("/ch10/shop/customer/list.do");
	}

}
