package controller.user5;

import java.io.IOException;

import dto.User5DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User5Service;

@WebServlet("/user5/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User5Service service = User5Service.INSTANCE;

	public ModifyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");

		User5DTO user = service.findById(seq);

		request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user5/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String seq = request.getParameter("seq");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");

		User5DTO dto = new User5DTO();
		dto.setSeq(seq);
		dto.setName(name);
		dto.setGender(gender);
		dto.setAge(Integer.parseInt(age));
		dto.setAddr(addr);

		service.modify(dto);

		response.sendRedirect("/ch10/user5/list.do");
	}

}
