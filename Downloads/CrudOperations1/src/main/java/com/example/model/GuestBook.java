package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class GuestBook {

	@Column
	public String guestName;
	@Column
	public String content;
	@Id
	@Column
	public int entryID;

	public GuestBook(String guestName2, String content2, int entryID2) {
		this.guestName = guestName2;
		this.content = content2;
		this.entryID = entryID2;
	}

	

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getEntryID() {
		return entryID;
	}

	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}

}
