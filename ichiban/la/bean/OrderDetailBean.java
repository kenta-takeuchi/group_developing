package la.bean;

import java.io.Serializable;


public class OrderDetailBean implements Serializable {
	private String order_id;
	private String product_code;
	private int quantity;
	private int total_fee;

	public OrderDetailBean(String order_id, String product_code, int quantity, int total_fee) {
		this.order_id = order_id;
		this.product_code = product_code;
		this.quantity = quantity;
		this.total_fee = total_fee;
	}

	public OrderDetailBean() {

	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getProductCode() {
		return product_code;
	}

	public void setProductCode(String product_code) {
		this.product_code = product_code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalFee() {
		return total_fee;
	}

	public void setTotlaFee(int total_fee) {
		this.total_fee = total_fee;
	}

}
