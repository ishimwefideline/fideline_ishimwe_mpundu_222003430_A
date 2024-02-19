package entity;



public class publisher{
private int id ; 
private String fname ;
private String lname ;
private String address ;
private String contact ;

public publisher() {}
public publisher(int id, String fname, String lname, String address, String contact) {
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.address = address;
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}

}



