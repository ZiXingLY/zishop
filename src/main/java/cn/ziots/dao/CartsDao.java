package cn.ziots.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import cn.ziots.entity.Carts;
import cn.ziots.util.SqlUtil;

public class CartsDao {
//	private PreparedStatement ps = null;
//	private ResultSet rs = null
	public int addGoods(Carts cart) {
		int i=0;
		String sql = "insert into carts (product_id,product_number,user_id) values(?,?,?)";
		try {
			PreparedStatement ps = SqlUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, cart.getPid());
			ps.setInt(2, cart.getPnumber());
			ps.setString(3, cart.getUid());
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public int deleteGoods(Carts cart) {
		int i=0;
		String sql = "delete from carts where c_id=?";
		try {
			PreparedStatement ps = SqlUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, cart.getId());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public int updateGoods(Carts cart) {
		int i=0;
		String sql = "update carts set product_number=? where c_id=?";
		try {
			PreparedStatement ps = SqlUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, cart.getPnumber());
			ps.setString(2, cart.getUid());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public LinkedList<Carts> getGoodsByUid(Carts cart){
		String sql = "select * from carts where u_id=?";
		LinkedList<Carts> llcart = new LinkedList<Carts>();
		try {
			PreparedStatement ps = SqlUtil.getConnection().prepareStatement(sql);
			ps.setString(1, cart.getUid());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cart.setId(rs.getInt("c_id"));
				cart.setPid(rs.getInt("product_id"));
				cart.setPnumber(rs.getInt("product_number"));
				cart.setUid(rs.getString("user_id"));
				llcart.add(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return llcart;
	}
	public Carts getProductByPid(Carts cart) {
		String sql = "select * from carts where product_id=? && user_id=?";
		try {
			PreparedStatement ps = SqlUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, cart.getPid());
			ps.setString(2, cart.getUid());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				cart.setId(rs.getInt("c_id"));
				cart.setPid(rs.getInt("product_id"));
				cart.setPnumber(rs.getInt("product_number"));
				cart.setUid(rs.getString("user_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cart;
	}
	public boolean hasGoods(Carts cart) {
		String sql = "select count(*) from carts where product_id=? && user_id=?";
		boolean has = false;
		try {
			PreparedStatement ps = SqlUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, cart.getPid());
			ps.setString(2, cart.getUid());
			ResultSet rs = ps.executeQuery();
			if(rs.next() && rs.getInt(1)>0) {
				has = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return has;
	}
}
