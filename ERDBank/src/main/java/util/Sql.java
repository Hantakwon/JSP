package util;

public class Sql {
	
	// Customer
	public final static String SELECT_CUSTOMER_BY_NO_AND_NAME = "SELECT * FROM BANK_CUSTOMER WHERE C_NO=? AND C_NAME=?";
	public final static String SELECT_CUSTOMER_WITH_ACCOUNT_NO = "SELECT c.*, a.a_no FROM BANK_CUSTOMER c JOIN BANK_ACCOUNT a ON c.c_no = a.a_c_no WHERE c_no = ?";
	
	// Account
	public final static String SELECT_ALL_ACCOUNT_WITH_NAME = "SELECT a.*, c.c_name FROM BANK_ACCOUNT a JOIN BANK_CUSTOMER c ON a.a_c_no = c.c_no";
	public final static String SELECT_ACCOUNT_WITH_NAME = "SELECT a.*, c.c_name FROM BANK_ACCOUNT a JOIN BANK_CUSTOMER c ON a.a_c_no = c.c_no WHERE A_NO = ?";
	public final static String UPDATE_ACCOUNT_PLUS = "UPDATE BANK_ACCOUNT SET A_BALANCE = A_BALANCE + ? WHERE A_NO = ? ";
	public final static String UPDATE_ACCOUNT_MINUS = "UPDATE BANK_ACCOUNT SET A_BALANCE = A_BALANCE - ? WHERE A_NO = ? ";
	
	// Transaction
	public final static String INSERT_TRANSACTION = "INSERT INTO BANK_TRANSACTION (T_A_NO, T_DIST, T_AMOUNT, T_DATETIME) VALUES (?,?,?,SYSDATE)" ;
	public final static String SELECT_TRANSACTION_BY_T_A_NO = "SELECT * FROM BANK_TRANSACTION WHERE T_A_NO = ?";

}
