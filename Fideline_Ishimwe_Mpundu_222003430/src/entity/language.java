package entity;


public class language{
private int id ; 
private String fname ;
private String lname ;
private String country ;


public language() {}
public language (int id, String fname, String lname, String country) {
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.country = country;
	
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
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





