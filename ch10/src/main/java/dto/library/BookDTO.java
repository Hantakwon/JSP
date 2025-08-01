package dto.library;

import java.sql.Date;

public class BookDTO {
	private int book_id;
	private String title;
	private String author;
	private String publisher;
	private String available;
	private Date reg_date;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "BookDTO [book_id=" + book_id + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", available=" + available + ", reg_date=" + reg_date + "]";
	}

}
