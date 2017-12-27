<%@ page language="java" contentType="text/html;"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.*, javax.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.math.*,cn.ziots.util.*"%>
<%
	String id = request.getParameter("p_id");
	try {
		// 准备语句执行对象 
		String sql = "select p_image from product where p_id=?";
		Connection conn = SqlUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			Blob b = rs.getBlob("p_image");
			long size = b.length();
			//out.print(size); 
			byte[] bs = b.getBytes(1, (int) size);
			response.setContentType("image/jpeg");
			OutputStream outs = response.getOutputStream();
			outs.write(bs);
			outs.flush();
			rs.close();
			out.clear();
			out = pageContext.pushBody();
		} else {
			rs.close();
			response.sendRedirect("./images/error.gif");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
%>