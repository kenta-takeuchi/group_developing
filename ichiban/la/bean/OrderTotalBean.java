package la.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderTotalBean implements Serializable {
	private Date ordered_date;
	private int count_of_order_detail;
	private BigDecimal total_fee;
	private BigDecimal average_fee;
	private BigDecimal max_fee;

	public OrderTotalBean(Date ordered_date, int count_of_order_detail, BigDecimal total_fee, BigDecimal average_fee, BigDecimal max_fee) {
		this.ordered_date = ordered_date;
		this.count_of_order_detail = count_of_order_detail;
		this.total_fee = total_fee;
		this.average_fee = average_fee;
		this.max_fee = max_fee;
	}

	public OrderTotalBean() {
	}

	public Date getOrdered_date() {
		return ordered_date;
	}

	public void setOrdered_date(java.sql.Date ordered_date) {
		this.ordered_date = ordered_date;
	}

	public int getCount_of_order_detail() {
		return count_of_order_detail;
	}

	public void setCount_of_order_detail(int count_of_order_detail) {
		this.count_of_order_detail = count_of_order_detail;
	}

	public java.math.BigDecimal getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(java.math.BigDecimal total_fee) {
		this.total_fee = total_fee;
	}

	public java.math.BigDecimal getAverage_fee() {
		return average_fee;
	}

	public void setAverage_fee(java.math.BigDecimal average_fee) {
		this.average_fee = average_fee;
	}

	public java.math.BigDecimal getMax_fee() {
		return max_fee;
	}

	public void setMax_fee(java.math.BigDecimal max_fee) {
		this.max_fee = max_fee;
	}

}
