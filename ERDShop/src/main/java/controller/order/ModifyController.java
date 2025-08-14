package controller.order;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dto.OrderDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.OrderService;

@WebServlet("/order/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderService service = OrderService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderNo = request.getParameter("orderNo");
		
		OrderDTO order = service.findById(Integer.parseInt(orderNo));
		request.setAttribute("order", order);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/order/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNo = request.getParameter("orderNo");
		String orderId = request.getParameter("orderId");
		String orderProduct = request.getParameter("orderProduct");
		String orderCount = request.getParameter("orderCount");
		String orderDateString = request.getParameter("orderDate");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate orderDateDate = LocalDate.parse(orderDateString, formatter);

		java.sql.Date orderDate = java.sql.Date.valueOf(orderDateDate);

		OrderDTO dto = new OrderDTO();
		dto.setOrderNo(Integer.parseInt(orderNo));
		dto.setOrderId(orderId);
		dto.setOrderProduct(Integer.parseInt(orderProduct));
		dto.setOrderCount(Integer.parseInt(orderCount));
		dto.setOrderDate(orderDate);
		
		service.modify(dto);
		
		response.sendRedirect("/shopApp/order/list.do");
	}

}
