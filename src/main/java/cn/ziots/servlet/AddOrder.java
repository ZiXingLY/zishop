package cn.ziots.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ziots.dao.CartsDao;
import cn.ziots.dao.CustomerDao;
import cn.ziots.dao.OrderDao;
import cn.ziots.dao.OrderDetailDao;
import cn.ziots.dao.ProductDao;
import cn.ziots.entity.Carts;
import cn.ziots.entity.Customer;
import cn.ziots.entity.OrderDetail;
import cn.ziots.entity.Orders;
import cn.ziots.entity.Product;

/**
 * Servlet implementation class AddOrder
 */
public class AddOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 提交订单成功后 将购物车中已提交的商品添加到订单详情
		 * 并将已添加订单从购物车表中删除
		 */
		HttpSession session = request.getSession();
		
		String username = session.getAttribute("me").toString();
		OrderDao dorder = new OrderDao();
		Orders order = new Orders();
		Customer customer = new Customer();
		customer.setUsername(username);
		CustomerDao dcustomer = new CustomerDao();
		customer = dcustomer.getCustomerByCname(username);
		order.setOpayment("未支付");
		order.setOaddress(customer.getAddress());
		order.setOemail(customer.getEmail());
		order.setOuser(username);
		/*
		 * 时间格式 
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		order.setOtime(sdf.format(new Date()));
		order.setOsum("订单摘要");
		
		if(dorder.addOrder(order)>=1) {
			System.out.println("订单添加成功");
			dorder.getProductByPid(order);
			CartsDao dcart = new CartsDao();
			Carts cart = new Carts();
			Product pro = new Product();
			ProductDao dpro = new ProductDao();
			OrderDetail od = new OrderDetail();
			OrderDetailDao dod = new OrderDetailDao();
			cart.setUid(username);
			Vector<Carts> vcart = dcart.getGoodsByUid(cart);
			for(Carts vc:vcart) {
				System.out.println("向量循环");
				pro.setId(cart.getPid());
				pro = dpro.getProductByPid(pro);
				od.setP_id(vc.getPid());
				od.setP_number(vc.getPnumber());
				od.setP_price(pro.getPrice());
				od.setOrder_id(order.getOid());
			if(	dod.addOrderDetail(od)>0)
				System.out.println("ddddd");
			else {
				System.out.println("添加失败");
			}
			}
			
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
