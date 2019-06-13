package la.bean;

import java.io.Serializable;

	public class OrderBean implements Serializable {
		private String id;
		private String customer_code;
		private String employee_code;
		private java.sql.Date ordered_date;
		private java.math.BigDecimal tax;
		private int count_of_order_detail;
		private java.math.BigDecimal total_fee;


		public OrderBean(String id, String customer_code, String employee_code, java.sql.Date ordered_date, java.math.BigDecimal tax, int count_of_order_detail, java.math.BigDecimal total_fee) {
			this.id = id;
			this.customer_code = customer_code;
			this.employee_code = employee_code;
			this.ordered_date = ordered_date;
			this.tax = tax;
			this.count_of_order_detail = count_of_order_detail;
			this.total_fee = total_fee;
			
		}

		public OrderBean() {

		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getCustomer_code() {
			return customer_code;
		}

		public void setCustomer_code(String customer_code) {
			this.customer_code = customer_code;
		}

		public String getEmployee_code() {
			return employee_code;
		}

		public java.sql.Date getOrdered_date() {
			return ordered_date;
		}

		public void setOrdered_date(java.sql.Date ordered_date) {
			this.ordered_date = ordered_date;
		}

		public java.math.BigDecimal getTax() {
			return tax;
		}

		public void setTax(java.math.BigDecimal tax) {
			this.tax = tax;
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

		public void setEmployee_code(String employee_code) {
			this.employee_code = employee_code;
		}

		public void getEmployee_code(String employee_code) {
			this.employee_code = employee_code;
		}
	}


