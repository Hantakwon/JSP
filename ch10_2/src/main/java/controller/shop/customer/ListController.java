package controller.shop.customer;

import java.io.IOException;
import java.lang.System.LoggerFinder;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/shop/customer/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerService service = CustomerService.INSTANCE;
	
	// 로거 생성
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    public ListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
		
		/*
		 * 개발환경에서는 System 출력으로 개발과정을 테스트할 수 있지만
		 * 배포환경에서는 System 출력이 자원낭비로 처리됨.
		 * 따라서 System 출력으로 하지 않고 Logger를 이용해 출력해야 됨.
		 * 
		 * 개발단계에서는 debug 레벨로 로그작업
		 * 배포단계에서는 warn 레벨 이상으로 로그작업
		 */
		logger.debug("debug here...1");
		logger.info("info here...1");
		logger.warn("warn here...1");
		logger.error("error here...1");
		
		customers = service.findAll();
		
		logger.debug("debug here...2 : " + customers);
		logger.info("info here...2 : " + customers);
		logger.warn("warn here...2 : " + customers);
		logger.error("error here...2 : " + customers);
		
		
		request.setAttribute("customers", customers);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/shop/customer/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
