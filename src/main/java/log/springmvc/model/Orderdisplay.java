package log.springmvc.model;

public class Orderdisplay {
	int O_id;
	String Username;
	String P_id ;
	int Qty;
	String Type;
	String Size;
	String Company;
	double  Price;
	double Tprice;
	String Date;
    String Status;
	
	public int getO_id() {
		return O_id;
	}
	public void setO_id(int o_id) {
		O_id = o_id;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
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
