package la.bean;

import java.io.Serializable;

public class EmployeeBean implements Serializable {
	private String code;
	private String name;
	private String password;
	private String admin_code;

	public EmployeeBean(String code, String name, String password, String admin_code) {
		this.code = code;
		this.name = name;
		this.password = password;
		this.admin_code = admin_code;
	}

	public EmployeeBean() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminCode() {
		return admin_code;
	}

	public void setAdminCode(String admin_code) {
		this.admin_code = admin_code;
	}
}
