package controller.shop.product;

import java.io.IOException;

import dto.shop.ProductDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.shop.ProductService;

@WebServlet("/shop/product/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private ProductService service = ProductService.INSTANCE;

    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/shop/product/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pno = request.getParameter("pno");
		String pname = request.getParameter("pname");
		String stock = request.getParameter("stock");
		String price = request.getParameter("price");
		String company = request.getParameter("company");
		
		ProductDTO dto = new ProductDTO();
		dto.setPno(Integer.parseInt(pno));
		dto.setPname(pname);
		dto.setStock(Integer.parseInt(stock));
		dto.setPrice(Integer.parseInt(price));
		dto.setCompany(company);
		
		service.register(dto);
		
		response.sendRedirect("/ch10/shop/product/list.do");
	}

}
