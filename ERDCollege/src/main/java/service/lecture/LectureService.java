package service.lecture;

import java.util.List;

import dao.lecture.LectureDAO;
import dto.lecture.LectureDTO;

public enum LectureService {
	
	INSTANCE;
	
	private LectureDAO dao = LectureDAO.getInstance();
	
	public void register(LectureDTO dto) {
		dao.insertLecture(dto);
	}
	public LectureDTO findById(int lecNo) {
		return dao.selectLecture(lecNo);
	}
	public List<LectureDTO> findAll() {
		return dao.selectAllLecture();
	}
	public void modify(LectureDTO dto) {
		dao.updateLecture(dto);
	}
	public void remove(int lecNo) {
		dao.deleteLecture(lecNo);
	}
	
}
