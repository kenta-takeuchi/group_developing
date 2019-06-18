package la.bean;

import java.io.Serializable;

public class UpdateBean implements Serializable{
	private String order_id;
	private String product_code;
	private int quantity;

	public UpdateBean(String order_id, String product_code, int quantity) {
		this.order_id = order_id;
		this.product_code = product_code;
		this.quantity = quantity;
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





}
