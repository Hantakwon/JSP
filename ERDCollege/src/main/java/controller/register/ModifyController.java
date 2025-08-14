package controller.register;

import java.io.IOException;

import dto.register.RegisterDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.register.RegisterService;

@WebServlet("/register/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RegisterService service = RegisterService.INSTANCE;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regStdNo = request.getParameter("regStdNo");
		String regLecNo = request.getParameter("regLecNo");

		RegisterDTO register = service.findById(regStdNo, Integer.parseInt(regLecNo));
		request.setAttribute("register", register);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/register/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regStdNo = request.getParameter("regStdNo");
		String regLecNo = request.getParameter("regLecNo");
		String regMidScore = request.getParameter("regMidScore");
		String regFinalScore = request.getParameter("regFinalScore");
		String regTotalScore = request.getParameter("regTotalScore");
		String regGrade = request.getParameter("regGrade");
		
		RegisterDTO dto = new RegisterDTO();
		dto.setRegStdNo(regStdNo);
		dto.setRegLecNo(Integer.parseInt(regLecNo));
		dto.setRegMidScore(Integer.parseInt(regMidScore));
		dto.setRegFinalScore(Integer.parseInt(regFinalScore));
		dto.setRegTotalScore(Integer.parseInt(regTotalScore));
		dto.setRegGrade(regGrade);
		
		service.modify(dto);
		
		response.sendRedirect("/ERDCollege/register/list.do");
	}

}
