package controller.library.member;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dto.library.MemberDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.library.MemberService;

@WebServlet("/library/member/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private MemberService service = MemberService.INSTANCE;
		
    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/library/member/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member_id = request.getParameter("member_id");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String hp = request.getParameter("hp");
		String join_dateString = request.getParameter("join_date");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date join_date = null; 
		
		try {
		    Date join_dateDate = format.parse(join_dateString);
		    
		    join_date = new java.sql.Date(join_dateDate.getTime());
		    
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		MemberDTO dto = new MemberDTO();
		dto.setMember_id(Integer.parseInt(member_id));
		dto.setName(name);
		dto.setAddress(address);
		dto.setHp(hp);
		dto.setJoin_date(join_date);
		
		service.register(dto);
		
		response.sendRedirect("/ch10/library/member/list.do");
	}

}
