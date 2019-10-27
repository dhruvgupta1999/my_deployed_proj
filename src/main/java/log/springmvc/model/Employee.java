package log.springmvc.model;

public class Employee {
	
	String Username ;
	String Salary ;
	String Password;
	String Address;
	String Phone;
	String Name;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String email) {
		Phone = email;
	}
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String name) {
		Username = name;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String Salary) {
		this.Salary = Salary;
	}
	
}
