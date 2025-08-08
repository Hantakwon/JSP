package controller.user5;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User5Service;

@WebServlet("/user5/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private User5Service service = User5Service.INSTANCE;
	
    public DeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seq = request.getParameter("seq");
		
		service.remove(seq);
		
		response.sendRedirect("/ch10/user5/list.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
