package cn.ziots.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ziots.entity.Product;
import cn.ziots.util.SqlUtil;

public class ProductDao extends Product{
	
	private PreparedStatement pstmt = null;
	private ResultSet rs=null;
	
	public int deleteProduct(Product product) {
		int i=0;
		String sql = "DELETE FROM product WHERE p_id=?";
		try {
			pstmt=(PreparedStatement) SqlUtil.getConnection().prepareStatement(sql);
			pstmt.setInt(1, product.getId());
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlUtil.closeAll();
		if(i==1)System.out.println("pro done!");
		else System.out.println("failtrue");
		return i;
	}
	public ResultSet showProduct() {
		String sql = "select * from product order by p_price desc limit 10";
		try {
			pstmt=(PreparedStatement) SqlUtil.getConnection().prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet selectProduct(ProductDao pro) {
		String sql = "select * from product where p_id=?";
		try {
			pstmt=(PreparedStatement) SqlUtil.getConnection().prepareStatement(sql);
			pstmt.setInt(1, pro.getId());
			rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public Product getProductByPid(Product pro) {
		String sql = "select * from product where p_id=?";
		try {
			PreparedStatement ps = SqlUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, pro.getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pro.setId(rs.getInt("p_id"));
				pro.setTpye(rs.getString("p_type"));
				pro.setBrand(rs.getString("p_brand"));
				pro.setName(rs.getString("p_name"));
				pro.setPrice(rs.getFloat("p_price"));
				pro.setQuantity(rs.getInt("p_quantity"));
				pro.setDescription(rs.getString("p_description"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pro;
	}
}
