package entity;



import java.sql.Date;

public class borrowing {
private int id ; 
private String amount;
private Date return_date ;
private Date borrow_date ;
public borrowing() {}
public borrowing(int id,Date return_date,String amount , Date  borrow_date ) {
	this.id = id;
	this. return_date= return_date;
	this. amount =  amount;
	this.borrow_date = borrow_date;
	
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public Date getReturn_date() {
	return return_date;
}
public void setReturn_date(Date return_date) {
	this.return_date = return_date;
}
public Date getBorrow_date() {
	return borrow_date;
}
public void setBorrow_date(Date borrow_date) {
	this.borrow_date = borrow_date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}


}

