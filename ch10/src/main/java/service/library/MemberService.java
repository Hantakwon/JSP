package service.library;

import java.util.List;

import dao.library.MemberDAO;
import dto.library.MemberDTO;

// 열거형으로 싱글톤 객체 생성
public enum MemberService {

	INSTANCE;
	
	private MemberDAO dao = MemberDAO.getInstance();
	
	// DAO 메서드 호출 - service에 맞게 네이밍
	public void register(MemberDTO dto) {
		dao.insertMember(dto);
	};
	
	public MemberDTO findById(int member_id) {
		return dao.selectMember(member_id);
	};
	
	public List<MemberDTO> findAll() {
		return dao.selectAllMember();
	};
	
	public void modify(MemberDTO dto) {
		dao.updateMember(dto);
	};
	
	public void delete(int member_id) {
		dao.deleteMember(member_id);
	};
}
