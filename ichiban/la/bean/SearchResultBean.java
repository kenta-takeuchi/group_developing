package la.bean;

public class SearchResultBean {
	private String date;
	private String id;
	private String customer_code;
	private String employee_code;

	public SearchResultBean(int date, int id, int employee_code, int customer_code) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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
