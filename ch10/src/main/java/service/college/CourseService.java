package service.college;

import java.util.List;

import dao.college.CourseDAO;
import dto.college.CourseDTO;

// 열거형으로 싱글톤 객체 생성
public enum CourseService {

	INSTANCE;
	
	private CourseDAO dao = CourseDAO.getInstance();
	
	// DAO 메서드 호출 - service에 맞게 네이밍
	public void register(CourseDTO dto) {
		dao.insertCourse(dto);
	};
	
	public CourseDTO findById(int cs_id) {
		return dao.selectCourse(cs_id);
	};
	
	public List<CourseDTO> findAll() {
		return dao.selectAllCourse();
	};
	
	public void modify(CourseDTO dto) {
		dao.updateCourse(dto);
	};
	
	public void delete(int cs_id) {
		dao.deleteCourse(cs_id);
	};
}
