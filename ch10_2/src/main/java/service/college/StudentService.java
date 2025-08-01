package service.college;

import java.util.List;

import dao.college.StudentDAO;
import dto.college.StudentDTO;

// 열거형으로 싱글톤 객체 생성
public enum StudentService {

	INSTANCE;
	
	private StudentDAO dao = StudentDAO.getInstance();
	
	// DAO 메서드 호출 - service에 맞게 네이밍
	public void register(StudentDTO dto) {
		dao.insertStudent(dto);
	};
	
	public StudentDTO findById(String stdno) {
		return dao.selectStudent(stdno);
	};
	
	public List<StudentDTO> findAll() {
		return dao.selectAllStudent();
	};
	
	public void modify(StudentDTO dto) {
		dao.updateStudent(dto);
	};
	
	public void delete(String stdno) {
		dao.deleteStudent(stdno);
	};
}
