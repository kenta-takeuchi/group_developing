package la.bean;

import java.io.Serializable;

public class SearchResultBean implements Serializable{
	private java.sql.Date date;
	private String id;
	private String customer_code;
	private String employee_code;

	public SearchResultBean(String id, java.sql.Date date, String employee_code, String customer_code) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.id = id;
		this.date = date;
		this.employee_code = employee_code;
		this.customer_code = customer_code;
	}

	public SearchResultBean() {

	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
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

	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}


}