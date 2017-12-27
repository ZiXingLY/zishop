package cn.ziots.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.ziots.entity.Product;
import cn.ziots.util.SqlUtil;

/**
 * Servlet implementation class addProduct
 */
@WebServlet("/addProduct")
public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// 检测是否为多媒体上传
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 如果不是则停止
			PrintWriter writer = response.getWriter();
			writer.println("Error: 表单必须包含 enctype=multipart/form-data");
			writer.flush();
			return;
		}

		// 配置上传参数
		DiskFileItemFactory factory = new DiskFileItemFactory();

		ServletFileUpload upload = new ServletFileUpload(factory);

		// 中文处理
		request.setCharacterEncoding("UTF-8");
		upload.setHeaderEncoding("UTF-8");
		// Parse the request
		List<FileItem> items;
		try {
			items = upload.parseRequest(request);

			Product pro = new Product();
			PreparedStatement pstmt;
			InputStream inputStream = null;

			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();

				if (item.isFormField()) {
					// processFormField(item);
					switch (item.getFieldName()) {
					case "id":
						System.out.println(item.getString());
						pro.setId(Integer.parseInt(item.getString()));
						break;
					case "type":
						System.out.println(item.getString());
						pro.setTpye(item.getString());
						break;
					case "name":
						System.out.println(item.getString());
						pro.setName(item.getString());
						break;
					case "brand":
						System.out.println(item.getString());
						pro.setBrand(item.getString());
						break;
					case "price":
						System.out.println(item.getString());
						pro.setPrice(Float.parseFloat(item.getString()));
						break;
					case "quantity":
						System.out.println(item.getString());
						pro.setQuantity(Integer.parseInt(item.getString()));
						break;
					case "description":
						System.out.println(item.getString());
						pro.setDescription(item.getString());
						break;

					default:
						break;
					}
				} else {
					inputStream = item.getInputStream();
				}
			}
			
			String sql = "insert into product (p_id,p_type,p_brand,p_name,p_price,p_quantity,p_image,p_description,p_time) values(?,?,?,?,?,?,?,?,?)";
			try {
				pstmt = (PreparedStatement) SqlUtil.getConnection().prepareStatement(sql);
//				pstmt.setString(1, key.getId());
				pstmt.setInt(1, pro.getId());
				pstmt.setString(2, pro.getTpye());
				pstmt.setString(3, pro.getBrand());
				pstmt.setString(4, pro.getName());
				pstmt.setFloat(5, pro.getPrice());
				
				pstmt.setInt(6, pro.getQuantity());
				pstmt.setBlob(7, inputStream);
				pstmt.setString(8,pro.getDescription());
				pstmt.setString(9, new Date().toString());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("addproduct failure!");
				e.printStackTrace();
			}
			SqlUtil.closeAll();
			request.setAttribute("message",
                    "商品添加成功");
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "错误信息: " + e.getMessage());
		}
		// 跳转到 message.jsp
		getServletContext().getRequestDispatcher("/message.jsp").forward(
	                request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
