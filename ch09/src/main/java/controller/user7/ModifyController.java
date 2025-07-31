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

@WebServlet("/user7/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private User7Service service = User7Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전송 데이터 수신
		String id = req.getParameter("id");
		
		// 수정 데이터 조회
		User7DTO dto = service.findById(id);
		
		req.setAttribute("user", dto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user7/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		service.modify(dto);
		
		// 이동
		resp.sendRedirect("/ch09/user7/list.do");
	}
}
