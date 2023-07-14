package com.seqato.MessengerProject;

import java.util.Date;


public class Comment 
{
	private int id;
	private String message;
	private Date created;
	private String author;
	
	public Comment()
	{
		
	}

	public Comment(int id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
