package controller.library.book;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dto.library.BookDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.library.BookService;

@WebServlet("/library/book/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BookService service = BookService.INSTANCE;
	
    public ModifyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String book_id = request.getParameter("book_id");
		
		BookDTO book = service.findById(Integer.parseInt(book_id));
		
		request.setAttribute("book", book);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/library/book/modify.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book_id = request.getParameter("book_id");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String available = request.getParameter("available");
		String reg_dateString = request.getParameter("reg_date");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date reg_date = null; 
		
		try {
		    Date reg_dateDate = format.parse(reg_dateString);
		    
		    reg_date = new java.sql.Date(reg_dateDate.getTime());
		    
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		BookDTO dto = new BookDTO();
		dto.setBook_id(Integer.parseInt(book_id));
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setPublisher(publisher);
		dto.setAvailable(available);
		dto.setReg_date(reg_date);
		
		service.modify(dto);
		
		response.sendRedirect("/ch10/library/book/list.do");
	}

}
