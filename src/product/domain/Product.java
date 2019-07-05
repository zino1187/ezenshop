package product.domain;
//model1, model2 방식에서는 데이터를 담는 객체를 DTO로 정의하기
//때문에 조인을 표현하기 위해서는 DTO들간 has a 관계로 표현하면됨
//이때 상위인 부모테이블은 다수의 자식을 보유할 경우 1:多 관계이므로
//자식은 집합형으로 선언해야 한다....List<자식형>
// collection : 부모를 기준으로 관점, 즉 부모객체를 기준으로 한 조인 
// association : 자식을 기준으로 한 관점 
public class Product {
	private int product_id;
	private SubCategory subCategory;
	private String product_name;
	private String brand;
	private int price;
	private String color;
	private String psize;
	private String filename;
	private String content;
	
	public Product() {
		subCategory = new SubCategory();
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPsize() {
		return psize;
	}

	public void setPsize(String psize) {
		this.psize = psize;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
	
}
