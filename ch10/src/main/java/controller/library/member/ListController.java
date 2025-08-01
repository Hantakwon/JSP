package controller.library.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.library.MemberDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.library.MemberService;

@WebServlet("/library/member/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberService service = MemberService.INSTANCE;
	
    public ListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MemberDTO> members = new ArrayList<MemberDTO>();
		
		members = service.findAll();
		
		request.setAttribute("members", members);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/library/member/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
