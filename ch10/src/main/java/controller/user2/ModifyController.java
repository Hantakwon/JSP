package controller.user2;

import java.io.IOException;

import dto.User2DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User2Service;

@WebServlet("/user2/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private User2Service service = User2Service.INSTANCE;
	
    public ModifyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		
		User2DTO user = service.findById(uid);
		
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/user2/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String addr = request.getParameter("addr");
		
		User2DTO dto = new User2DTO();
		dto.setUid(uid);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setAddr(addr);
		
		service.modify(dto);
		
		response.sendRedirect("/ch10/user2/list.do");
	}

}
