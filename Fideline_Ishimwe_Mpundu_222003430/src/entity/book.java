package entity;



public class book{
private String title ;
private String isbn;
private String pubyear;
private int id;


public book() {}
public book(int id, String title, String isbn,String pubyear) {
	this.id = id;
	this.title = title;
	this.isbn = isbn;
	this.pubyear = pubyear;
	
}
public String getPubyear() {
	return pubyear;
}
public void setPubyear(String pubyear) {
	this.pubyear = pubyear;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


}

