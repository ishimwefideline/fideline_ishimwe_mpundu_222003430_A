package entity;

import java.sql.Date;

public class author {
private int id ; 
private String fname ;
private String lname ;
private String biography ;

public author() {}
public author(int id, String fname, String lname, String biography, Date birthdate) {
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.biography = biography;
	
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
public String getBiography() {
	return biography;
}
public void setBiography(String biography) {
	this.biography = biography;
}



}

