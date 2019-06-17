package la.bean;

import java.io.Serializable;

public class UpdateBean implements Serializable{
	private String orderCode;
	private String productName;
	private int quantity;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public UpdateBean() {
	}

	public UpdateBean(String orderCode, String productName, int quantity) {
		this.orderCode = orderCode;
		this.productName = productName;
		this.quantity = quantity;
	}



}
