package cn.ziots.util;

import java.util.Vector;

public class Cart {
	private String p_id;
	private int p_number;
public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public int getP_number() {
		return p_number;
	}
	public void setP_number(int p_number) {
		this.p_number = p_number;
	}
	public Vector getCart() {
		return cart;
	}
	public void setCart(Vector cart) {
		this.cart = cart;
	}
	
	private Vector cart;
	public Vector addCart(String p_id,Vector cart) {
		this.cart=cart;
		this.p_id = p_id;
		this.p_number = 1;
		boolean Flag = true;
		if(cart==null) {
			cart = new Vector();
		}else {
			for(int i=0;i<cart.size();i++) {
				Cart goodsitem = (Cart) cart.elementAt(i);
				if(goodsitem.p_id.equals(this.p_id)) {
					goodsitem.p_number++;
					cart.setElementAt(goodsitem, i);
					Flag=false;
				}
			}
		}
		if(Flag) {
			cart.addElement(this);
		}
		return cart;
	}
	public int deleteCart(int c_id,Vector cart) {
		this.cart=cart;
		if(cart==null) {
			return 0;
		}else {
			cart.remove(c_id);
			return 1;
		}
		
	}
	public Cart updateCart(Vector cart,int c_id,String num) {
		this.cart = cart;
		Cart goodsitem = (Cart) cart.elementAt(c_id);
		String sum=num;
		if(sum!=null && sum!=null) {
			goodsitem.p_number=Integer.parseInt(sum);
		}return goodsitem;
	}
}