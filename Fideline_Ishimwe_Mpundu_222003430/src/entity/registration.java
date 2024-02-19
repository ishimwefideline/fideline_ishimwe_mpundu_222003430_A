package entity;

public class registration {
	private int id;
	private String name;
	private String address;
	private String email;
	private String username;
	private String password;
	private String hireddate;
	private int phonenumber;

	public registration() {}
	public registration(int id, String name,String address, String email,String username,String password,String hireddate,int phonenumber) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.hireddate =hireddate;
		this.phonenumber = phonenumber;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHireddate() {
		return hireddate;
	}
	public void setHireddate(String hireddate) {
		this.hireddate = hireddate;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
}
