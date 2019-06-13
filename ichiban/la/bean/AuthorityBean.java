package la.bean;

import java.io.Serializable;

public class AuthorityBean implements Serializable {
	private String code;
	private String authority;

	public AuthorityBean(String code, String authority) {
		this.code = code;
		this.authority = authority;
	}

	public AuthorityBean() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
