package service.transaction;

import java.util.List;

import dao.transaction.TransactionDAO;
import dto.transaction.TransactionDTO;

public enum TransactionService {

	INSTANCE;
	
	private TransactionDAO dao = TransactionDAO.getInstance();
	
	public void transfer(TransactionDTO dto) {
		dao.insertAndUpdateTransaction(dto);
	}
	public List<TransactionDTO> findByTANO(String t_a_no) {
		return dao.selectByTANoTransaction(t_a_no);
	}
	public TransactionDTO findById(int t_no) {
		return dao.selectTransaction(t_no);
	}
	public List<TransactionDTO> findAll() {
		return dao.selectAllTransaction();
	}
	public void modify(TransactionDTO dto) {
		dao.updateTransaction(dto);
	}
	public void remove(int t_no) {
		dao.deleteTransaction(t_no);
	}
}
