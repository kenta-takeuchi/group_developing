package la.bean;

import java.io.Serializable;
import java.math.BigDecimal;


public class OrderDetailBean implements Serializable {
	private String order_id;
	private String product_code;
	private int quantity;
	private BigDecimal total_fee;

	public OrderDetailBean(String order_id, String product_code, int quantity, BigDecimal total_fee) {
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

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(BigDecimal total_fee) {
		this.total_fee = total_fee;
	}

}
