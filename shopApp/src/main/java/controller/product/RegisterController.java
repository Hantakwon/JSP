package controller.product;

import java.io.IOException;

import dto.ProductDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductService;

@WebServlet("/product/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private ProductService service = ProductService.INSTANCE;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/product/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodNo = request.getParameter("prodNo");
		String prodName = request.getParameter("prodName");
		String stock = request.getParameter("stock");
		String price = request.getParameter("price");
		String company = request.getParameter("company");
		
		ProductDTO dto = new ProductDTO();
		dto.setProdNo(Integer.parseInt(prodNo));
		dto.setProdName(prodName);
		dto.setStock(Integer.parseInt(stock));
		dto.setPrice(Integer.parseInt(price));
		dto.setCompany(company);
		
		service.register(dto);
		
		response.sendRedirect("/shopApp/product/list.do");
	}

}
