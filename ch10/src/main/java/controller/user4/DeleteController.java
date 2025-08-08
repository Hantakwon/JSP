package controller.user4;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User4Service;

@WebServlet("/user4/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private User4Service service = User4Service.INSTANCE;
	
    public DeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		
		service.remove(uid);
		
		response.sendRedirect("/ch10/user4/list.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
