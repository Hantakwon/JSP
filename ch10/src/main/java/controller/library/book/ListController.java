package controller.library.book;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dto.library.BookDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.library.BookService;

@WebServlet("/library/book/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BookService service = BookService.INSTANCE;
	
    public ListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BookDTO> books = new ArrayList<BookDTO>();
		
		books = service.findAll();
		
		request.setAttribute("books", books);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/library/book/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
