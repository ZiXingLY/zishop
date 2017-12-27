package cn.ziots.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ziots.entity.Customer;
import cn.ziots.util.SqlUtil;

public class CustomerDao extends Customer{
	
	private PreparedStatement pstmt = null;
	private ResultSet rs=null;
	
	public int getCustomerNo(Customer customer) {

		int i = 0;
		String sql = "select count(*) from customer where c_name=? && c_pass=?";
		try {
			pstmt = (PreparedStatement) SqlUtil.getConnection().prepareStatement(sql);
			pstmt.setString(1, customer.getUsername());
			pstmt.setString(2, customer.getPassword());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("getCustomerNo failure!");
			e.printStackTrace();
		}
		SqlUtil.closeAll();
		return i;
	}
	
	public  int addCustomer(Customer customer) {
		int i = 0;
		String sql = "insert into customer (c_name,c_pass,c_header,c_phone,c_question,c_answer,c_address,c_email) values(?,?,?,?,?,?,?,?)";
		try {
			pstmt = (PreparedStatement) SqlUtil.getConnection().prepareStatement(sql);
//			pstmt.setString(1, key.getId());
			pstmt.setString(1, customer.getUsername());
			pstmt.setString(2, customer.getPassword());
			pstmt.setString(3, customer.getHeader());
			pstmt.setString(4, customer.getPhone());
			pstmt.setString(5, customer.getQuestion());
			pstmt.setString(6, customer.getAnswer());
			pstmt.setString(7, customer.getAddress());
			pstmt.setString(8, customer.getEmail());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("addCustomer failure!");
			e.printStackTrace();
		}
		SqlUtil.closeAll();
		return i;
	}
}
