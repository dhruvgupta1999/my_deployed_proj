package log.springmvc.model;

public class Cartdisplay {
	String Username;
	String P_id ;
	int Qty;
	String Type;
	String Size;
	String Company;
	double  Price;
	double Tprice;
	int C_id;
	
	public int getC_id() {
		return C_id;
	}
	public void setC_id(int c_id) {
		C_id = c_id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getP_id() {
		return P_id;
	}
	public void setP_id(String p_id) {
		P_id = p_id;
	}
	public int getQty() {
		return Qty;
	}
	public void setQty(int qty) {
		Qty = qty;
	}
	public String getType() {
		System.out.println("reached getType");
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public double getTprice() {
		return Tprice;
	}
	public void setTprice(double tprice) {
		Tprice = tprice;
	}
	
}
