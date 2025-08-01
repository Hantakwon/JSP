package dao.library;

import java.security.AlgorithmParametersSpi;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dto.bank.AccountDTO;
import dto.library.BookDTO;
import util.DBHelper;

public class BookDAO extends DBHelper{
	private final static BookDAO INSTANCE = new BookDAO();

	public static BookDAO getInstance() {
		return INSTANCE;
	}

	private BookDAO() {
	}

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String DBCP = "jdbc/library";
	
	public void insertBook(BookDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "INSERT INTO BOOK VALUES(?, ?, ?, ?, ?, ?)";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, dto.getBook_id());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getAuthor());
			psmt.setString(4, dto.getPublisher());
			psmt.setString(5, dto.getAvailable());
			psmt.setDate(6, dto.getReg_date());

			psmt.executeUpdate();
			
			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
	};

	public BookDTO selectBook(int book_id) {
		
		BookDTO dto = null;
		
		try {
			conn = getConnection(DBCP);
			
			String sql = "SELECT * FROM BOOK WHERE BOOK_ID = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, book_id);

			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new BookDTO();
				dto.setBook_id(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setAuthor(rs.getString(3));
				dto.setPublisher(rs.getString(4));
				dto.setAvailable(rs.getString(5));
				dto.setReg_date(rs.getDate(6));
			}

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 

		return dto;
	};

	public List<BookDTO> selectAllBook() {

		List<BookDTO> bookList = new ArrayList<BookDTO>();
		
		try {
			conn = getConnection(DBCP);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM BOOK";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setBook_id(rs.getInt(1));
				dto.setTitle(rs.getString(2));
				dto.setAuthor(rs.getString(3));
				dto.setPublisher(rs.getString(4));
				dto.setAvailable(rs.getString(5));
				dto.setReg_date(rs.getDate(6));
				
				bookList.add(dto);
			}

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 

		return bookList;
	};

	public void updateBook(BookDTO dto) {
		try {
			conn = getConnection(DBCP);
			
			String sql = "UPDATE BOOK SET TITLE=?, AUTHOR=?, PUBLISHER=?, AVAILABLE=?, REG_DATE=? WHERE BOOK_ID = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getAuthor());
			psmt.setString(3, dto.getPublisher());
			psmt.setString(4, dto.getAvailable());
			psmt.setDate(5, dto.getReg_date());
			psmt.setInt(6, dto.getBook_id());
			
			psmt.execute();

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
	};

	public void deleteBook(int book_id) {

		try {
			conn = getConnection(DBCP);
			
			String sql = "DELETE FROM BOOK WHERE BOOK_ID = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, book_id);

			psmt.execute();

			closeAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} 
	};
}
