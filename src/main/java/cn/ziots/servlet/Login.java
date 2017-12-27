package cn.ziots.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ziots.dao.CustomerDao;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	
    	CustomerDao customer = new CustomerDao();
    	
    	HttpSession session = ((HttpServletRequest)request).getSession();
		response.setCharacterEncoding("utf-8");
    	
    	customer.setUsername(username);
    	customer.setPassword(password);
    	if(customer.getCustomerNo(customer)>=1){
    		session.setAttribute("login", "ok");
    		session.setAttribute("me",username);
    		response.sendRedirect("index.jsp");
    	}
    	else{
    		PrintWriter out = response.getWriter();
    		out.print("<h2>登陆失败，请重新登录</h2>");
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
