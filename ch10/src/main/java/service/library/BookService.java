package service.library;

import java.util.List;

import dao.library.BookDAO;
import dto.library.BookDTO;

// 열거형으로 싱글톤 객체 생성
public enum BookService {

	INSTANCE;
	
	private BookDAO dao = BookDAO.getInstance();
	
	// DAO 메서드 호출 - service에 맞게 네이밍
	public void register(BookDTO dto) {
		dao.insertBook(dto);
	};
	
	public BookDTO findById(int book_id) {
		return dao.selectBook(book_id);
	};
	
	public List<BookDTO> findAll() {
		return dao.selectAllBook();
	};
	
	public void modify(BookDTO dto) {
		dao.updateBook(dto);
	};
	
	public void delete(int book_id) {
		dao.deleteBook(book_id);
	};
}
