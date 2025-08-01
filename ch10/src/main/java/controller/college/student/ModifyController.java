package controller.college.student;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dto.college.StudentDTO;
import dto.shop.CustomerDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.college.StudentService;

@WebServlet("/college/student/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentService service = StudentService.INSTANCE;
	
    public ModifyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String stdno = request.getParameter("stdno");
		
		StudentDTO student = service.findById(stdno);
		
		request.setAttribute("student", student);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/college/student/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stdno = request.getParameter("stdno");
		String name = request.getParameter("name");
		String birthString = request.getParameter("birth");
		String major = request.getParameter("major");
		String enr_dateString = request.getParameter("enr_date");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date birth = null; 
		java.sql.Date enr_date = null;
		
		try {
		    Date birthDate = format.parse(birthString);
		    Date enr_dateDate = format.parse(enr_dateString);
		    
		    birth = new java.sql.Date(birthDate.getTime());
		    enr_date = new java.sql.Date(enr_dateDate.getTime());
		    
		} catch (ParseException e) {
		    e.printStackTrace();
		}

		StudentDTO dto = new StudentDTO();
		dto.setStdno(stdno);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setMajor(major);
		dto.setEnr_date(enr_date);
		
		service.modify(dto);
		
		response.sendRedirect("/ch10/college/student/list.do");
	}

}
