package controller.user7;

import java.io.IOException;

import dto.User7DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User7Service;

@WebServlet("/user7/register.do")
public class RegisterController extends HttpServlet {

	// Service 싱글톤 객체 가져오기
	private User7Service service = User7Service.getInstance();
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user7/register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전송 데이터 수신
		String id = req.getParameter("id");
		String name = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("address");
		
		// 서비스 전달을 위해 DTO 생성
		User7DTO dto = new User7DTO();
		dto.setId(id);
		dto.setName(name);
		dto.setAge(age);
		dto.setEmail(email);
		
		// 서비스 요청
		service.register(dto);
		
		// 이동
		resp.sendRedirect("/ch09/user7/list.do");
	}
}
