package controller.order;

import java.io.IOException;
import java.util.List;

import dto.OrderDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.OrderService;

@WebServlet("/order/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderService service = OrderService.INSTANCE;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<OrderDTO> orderList = service.findAll();
		
		request.setAttribute("orderList", orderList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/order/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}