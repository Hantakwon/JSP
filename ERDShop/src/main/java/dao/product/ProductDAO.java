package dao.product;

import java.util.ArrayList;
import java.util.List;

import dto.ProductDTO;
import util.DBHelper;

public class ProductDAO extends DBHelper {

	private static final ProductDAO INSTANCE = new ProductDAO();

	public static ProductDAO getInstance() {
		return INSTANCE;
	}

	private ProductDAO() {
	}

	private final String DBCP = "jdbc/shopERD";

	public void insertProduct(ProductDTO dto) {

		try {
			conn = getConnection(DBCP);

			String sql = "INSERT INTO Product VALUES (?, ?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getProdNo());
			psmt.setString(2, dto.getProdName());
			psmt.setInt(3, dto.getStock());
			psmt.setInt(4, dto.getPrice());
			psmt.setString(5, dto.getCompany());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ProductDTO selectProduct(int prodNo) {
		ProductDTO dto = new ProductDTO();
		
		try {
			conn = getConnection(DBCP);
			String sql = "SELECT * FROM Product WHERE PRODNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, prodNo);
			
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				dto.setProdNo(rs.getInt(1));
				dto.setProdName(rs.getString(2));
				dto.setStock(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setCompany(rs.getString(5));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public List<ProductDTO> selectAllProduct() {

		List<ProductDTO> dtoList = new ArrayList<ProductDTO>();

		try {
			conn = getConnection(DBCP);
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM Product");

			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setProdNo(rs.getInt(1));
				dto.setProdName(rs.getString(2));
				dto.setStock(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setCompany(rs.getString(5));
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public void updateProduct(ProductDTO dto) {
		try {
			conn = getConnection(DBCP);

			String sql = "UPDATE Product SET PRODNAME=?, STOCK=?, PRICE=?, COMPANY=? WHERE PRODNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getProdName());
			psmt.setInt(2, dto.getStock());
			psmt.setInt(3, dto.getPrice());
			psmt.setString(4, dto.getCompany());
			psmt.setInt(5, dto.getProdNo());
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteProduct(int prodNo) {
		try {
			conn = getConnection(DBCP);

			String sql = "DELETE FROM Product WHERE PRODNO = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, prodNo);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
