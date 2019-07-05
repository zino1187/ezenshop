package product.domain;
//model1, model2 ��Ŀ����� �����͸� ��� ��ü�� DTO�� �����ϱ�
//������ ������ ǥ���ϱ� ���ؼ��� DTO�鰣 has a ����� ǥ���ϸ��
//�̶� ������ �θ����̺��� �ټ��� �ڽ��� ������ ��� 1:�� �����̹Ƿ�
//�ڽ��� ���������� �����ؾ� �Ѵ�....List<�ڽ���>
// collection : �θ� �������� ����, �� �θ�ü�� �������� �� ���� 
// association : �ڽ��� �������� �� ���� 
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
