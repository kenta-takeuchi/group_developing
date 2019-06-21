package la.bean;

public class ProductBean {
	private String code;
	private String category_code;
	private String name;
	private int price;
	private String unit;

	public ProductBean(
			String code,
			String category_code,
			String name,
			int price,
			String unit) {

		this.code = code;
		this.category_code = category_code;
		this.name = name;
		this.price = price;
		this.unit = unit;

	}

	public ProductBean(
			String code,
			String name) {

		this.code = code;
		this.name = name;

	}

	public ProductBean() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategory_Code() {
		return category_code;
	}

	public void setCategory_Code(String category_code) {
		this.category_code = category_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}



}
