package com.example.model;
import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;     
@Entity  
@Table  
public class guestbook 
{  
 
@Column  
private int guestName;  
@Column  
private String content;  
@Id 
@Column  
private String entryID;
public int getGuestName() {
	return guestName;
}
public void setGuestName(int guestName) {
	this.guestName = guestName;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getEntryID() {
	return entryID;
}
public void setEntryID(String entryID) {
	this.entryID = entryID;
}  


}  

