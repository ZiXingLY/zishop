package cn.ziots.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Account
 */
@WebFilter(urlPatterns="/account.jsp,/AddCartDate")
public class Account implements Filter {

    /**
     * Default constructor. 
     */
    public Account() {
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpSession session = ((HttpServletRequest)request).getSession();
		response.setCharacterEncoding("utf-8");
		
		if(session.getAttribute("me") == null) {
			PrintWriter out = response.getWriter();
			out.print("<html><body><h2> 请先登录，谢谢！</h2>");
			out.print("<h2> 2秒后，自动跳转到登录页面！</h2></body></html>");
			((HttpServletResponse)response).setHeader("Refresh","2;URl=login.jsp");
		}else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
		
		
	}

	
}
