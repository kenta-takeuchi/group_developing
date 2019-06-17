package la.bean;

import java.io.Serializable;

public class OrderAnalyzeBean implements Serializable {
	private String product_code;
	private String product_name;
	private int this_quantity;
	private int pre_quantity;
	private int compare_quantity;

	public OrderAnalyzeBean(String product_code, String product_name, int this_quantity, int pre_quantity, int compare_quantity) {
		this.product_code = product_code;
		this.product_name = product_name;
		this.this_quantity = this_quantity;
		this.pre_quantity = pre_quantity;
		this.compare_quantity = compare_quantity;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getThis_quantity() {
		return this_quantity;
	}

	public void setThis_quantity(int this_quantity) {
		this.this_quantity = this_quantity;
	}

	public int getPre_quantity() {
		return pre_quantity;
	}

	public void setPre_quantity(int pre_quantity) {
		this.pre_quantity = pre_quantity;
	}

	public int getCompare_quantity() {
		return compare_quantity;
	}

	public void setCompare_quantity(int compare_quantity) {
		this.compare_quantity = compare_quantity;
	}

}
