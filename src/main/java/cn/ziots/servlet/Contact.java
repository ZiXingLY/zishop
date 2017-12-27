package cn.ziots.servlet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/Contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		
		// 收件人电子邮箱
        String to = "zinianly@163.com";
		
        // 发件人电子邮箱
        String from = "1319589118@qq.com";
//        	if(request.getParameter("email") != null) {
//        		from=request.getParameter("email");
//        	}
        String mes = "This is actual message";
        if(request.getParameter("message") != null) {
    		mes=request.getParameter("message");
    	}
        System.out.println(mes);
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        
        mes = "user:"+name+" phone:"+phone+"to you:"+mes;
        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf;
		try {
			sf = new MailSSLSocketFactory();
			
			  sf.setTrustAllHosts(true);
		        properties.put("mail.smtp.ssl.enable", "true");
		        properties.put("mail.smtp.ssl.socketFactory", sf);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("1319589118@qq.com", "ptnechjywvnqgaag"); //发件人邮件用户名、密码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("用户反馈！");

            // 设置消息体
            message.setText(mes);

            // 发送消息
            Transport.send(message);
            request.setAttribute("message",
                    "邮件发送成功！");
            System.out.println("Sent message successfully....from zishop");
        }catch (MessagingException mex) {
            mex.printStackTrace();
            request.setAttribute("message", "错误信息: " + mex.getMessage());
        }
		   getServletContext().getRequestDispatcher("/message.jsp").forward(
	                request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
