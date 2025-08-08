package controller.user4;

import java.io.IOException;

import dto.User4DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User4Service;

@WebServlet("/user4/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User4Service service = User4Service.INSTANCE;

	public ModifyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");

		User4DTO user = service.findById(uid);

		request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user4/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String hp = request.getParameter("hp");
		String addr = request.getParameter("addr");

		User4DTO dto = new User4DTO();
		dto.setUid(uid);
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(Integer.parseInt(age));
		dto.setHp(hp);
		dto.setAddr(addr);

		service.modify(dto);

		response.sendRedirect("/ch10/user4/list.do");
	}

}
