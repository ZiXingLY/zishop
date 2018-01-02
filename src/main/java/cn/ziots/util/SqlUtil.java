package cn.ziots.util;

import java.sql.*;

public class SqlUtil {

	private static String url = "jdbc:mysql://localhost:3306/zishop";
	private static String user = "root";
	private static String password = "hanghang";
	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("not found com...Driver");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("create conn failure!");
		}
		return conn;
	}
//	public static PreparedStatement getPrepareStatement(String sql){
//		
//		try {
//			pstmt =  getConnection().prepareStatement(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return pstmt;
//	}
	
//	public static ResultSet getResultSet(){
//		
//		try {
//			rs =  pstmt.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return rs;
//	}
	public static void closeAll() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally {
						if (conn != null)
							try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

					}

			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		if (conn != null)
			try {
				conn.close();
				System.out.println("SqlUtil is closed...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
