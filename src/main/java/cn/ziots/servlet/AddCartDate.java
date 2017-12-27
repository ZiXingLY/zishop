package cn.ziots.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ziots.dao.CartsDao;
import cn.ziots.entity.Carts;

/**
 * Servlet implementation class AddCartDate
 */
@WebServlet("/AddCartDate")
public class AddCartDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		int pid = Integer.parseInt(request.getParameter("p_id"));
		String uid = (String) session.getAttribute("me");
		/*
		 * 如果用户购物车不存在此商品，则添加此记录；否则此商品数目加一。
		 */
		Carts cart = new Carts();
		CartsDao dcart = new CartsDao();
		
		cart.setPid(pid);
		cart.setUid(uid);
		
		if(!dcart.hasGoods(cart)) {
			cart.setPnumber(1);
			dcart.addGoods(cart);
		}else {
			int number = dcart.getProductByPid(cart).getPnumber();
//			System.out.println("当前商品数量："+number);
			cart.setPnumber(++number);
			dcart.updateGoods(cart);
		}
		response.sendRedirect("cart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
