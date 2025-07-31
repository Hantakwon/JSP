package controller.user6;

import java.io.IOException;

import dto.User6DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User6Service;

@WebServlet("/user6/modify.do")
public class ModifyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private User6Service service = User6Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전송 데이터 수신
		int seq = Integer.parseInt(req.getParameter("seq"));
		
		// 수정 데이터 조회
		User6DTO dto = service.findById(seq);
		
		req.setAttribute("user", dto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user6/modify.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int seq = Integer.parseInt(req.getParameter("seq"));
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		String address = req.getParameter("address");
		
		// 서비스 전달을 위해 DTO 생성
		User6DTO dto = new User6DTO();
		dto.setSeq(seq);
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(age);
		dto.setAddress(address);
		
		service.modify(dto);
		
		// 이동
		resp.sendRedirect("/ch09/user6/list.do");
	}
}
