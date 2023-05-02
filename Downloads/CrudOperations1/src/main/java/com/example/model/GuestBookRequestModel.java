package com.example.model;

public class GuestBookRequestModel {
	public String guestName;
	public String content;
	public int entryID;
	public GuestBookRequestModel(String guestName, String Content, int entryID) {
		this.guestName = guestName;
		this.content = Content;
		this.entryID = entryID;
	}
}
