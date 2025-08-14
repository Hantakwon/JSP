package controller.order;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import dto.CustomerDTO;
import dto.OrderDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.OrderService;

@WebServlet("/order/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private OrderService service = OrderService.INSTANCE;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerDTO sessUser = (CustomerDTO) session.getAttribute("sessUser");
		
		String orderId = sessUser.getCustId();
		String orderProduct = request.getParameter("prodNo");
		String orderCount = request.getParameter("prodCount");
		LocalDate nowDate = LocalDate.now();

		Date orderDate = Date.valueOf(nowDate);

		OrderDTO dto = new OrderDTO();
		dto.setOrderId(orderId);
		dto.setOrderProduct(Integer.parseInt(orderProduct));
		dto.setOrderCount(Integer.parseInt(orderCount));
		dto.setOrderDate(orderDate);
		
		service.register(dto);
		
		response.sendRedirect("/shopApp/order/list.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
