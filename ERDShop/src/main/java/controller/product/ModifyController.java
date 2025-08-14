package controller.product;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dto.CustomerDTO;
import dto.ProductDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductService;

@WebServlet("/product/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductService service = ProductService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prodNo = request.getParameter("prodNo");
		
		ProductDTO product = service.findById(Integer.parseInt(prodNo));
		request.setAttribute("product", product);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/product/modify.jsp");
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
		
		service.modify(dto);
		
		response.sendRedirect("/shopApp/product/list.do");
	}

}
