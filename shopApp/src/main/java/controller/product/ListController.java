package controller.product;

import java.io.IOException;
import java.util.List;

import dto.CustomerDTO;
import dto.ProductDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ProductService;

@WebServlet("/product/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductService service = ProductService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		CustomerDTO sessUser = (CustomerDTO) session.getAttribute("sessUser");
		
		List<ProductDTO> productList = service.findAll();
		
		request.setAttribute("sessUser", sessUser);
		request.setAttribute("productList", productList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/product/list.jsp");
		dispatcher.forward(request, response);
	 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}