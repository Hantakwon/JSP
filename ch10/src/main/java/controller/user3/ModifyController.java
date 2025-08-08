package controller.user3;

import java.io.IOException;

import dto.User3DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User3Service;

@WebServlet("/user3/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User3Service service = User3Service.INSTANCE;

	public ModifyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");

		User3DTO user = service.findById(uid);

		request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user3/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String hp = request.getParameter("hp");
		String addr = request.getParameter("addr");

		User3DTO dto = new User3DTO();
		dto.setUid(uid);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setHp(hp);
		dto.setAddr(addr);

		service.modify(dto);

		response.sendRedirect("/ch10/user3/list.do");
	}

}
