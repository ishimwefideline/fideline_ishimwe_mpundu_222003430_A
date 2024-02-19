package entity;

import java.sql.Date;

public class user {
public int id ; 
public String fname ;
public String lname ;
public String address ;
public String contact ;
public Date   birthdate ;
public String username;
public String password;
public user() {}
public user(int id, String fname, String lname, String address,String contact, Date birthdate,String username,String password) {
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.address = address;
	this.contact = contact;
	this.birthdate = birthdate;
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

public Date getBirthdate() {
	return birthdate;
}
public void setBirthdate(Date birthdate) {
	this.birthdate = birthdate;
}


}
