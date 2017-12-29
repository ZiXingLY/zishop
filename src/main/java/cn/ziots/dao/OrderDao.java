package cn.ziots.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ziots.entity.Carts;
import cn.ziots.entity.Orders;
import cn.ziots.util.SqlUtil;

public class OrderDao {
	public int addOrder(Orders order) {
		int i=0;
		String sql = "insert into orders (order_payment,order_address,order_email,order_user,order_time,order_sum) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = SqlUtil.getConnection().prepareStatement(sql);
			ps.setString(1, order.getOpayment());
			ps.setString(2, order.getOaddress());
			ps.setString(3, order.getOemail());
			ps.setString(4, order.getOuser());
			ps.setString(5, order.getOtime());
			ps.setString(6, order.getOsum());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public int deleteOrder(Orders o) {
		int i=0;
		String sql = "delete from carts where order_id=?";
		try {
			PreparedStatement ps = SqlUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, o.getOid());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public int updateOrder(Orders order) {
		int i=0;
		String sql = "update orders set order_payment=?,order_address=?,order_email=?,order_user=?,order_time=?,order_sum=? where order_id=?";
		try {
			PreparedStatement ps = SqlUtil.getConnection().prepareStatement(sql);
			ps.setString(1, order.getOpayment());
			ps.setString(2, order.getOaddress());
			ps.setString(3, order.getOemail());
			ps.setString(4, order.getOuser());
			ps.setString(5, order.getOtime());
			ps.setString(6, order.getOsum());
			i = ps.executeUpdate();
			System.out.println("执行结果:"+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public Orders getProductByPid(Orders order) {
		String sql = "select * from orders where order_user=? && order_time=?";
		try {
			PreparedStatement ps = SqlUtil.getConnection().prepareStatement(sql);
			ps.setString(1, order.getOuser());
			ps.setString(2, order.getOtime());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				order.setOid(rs.getInt("order_id"));
				order.setOpayment(rs.getString("order_payment"));
				order.setOaddress(rs.getString("order_address"));
				order.setOemail(rs.getString("order_email"));
				order.setOuser(rs.getString("order_user"));
				order.setOtime(rs.getString("order_time"));
				order.setOsum(rs.getString("order_sum"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}
}
