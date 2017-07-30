package com.m3itsolution.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Id;

@Entity
@Table(name = "todo")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name ="userID")
	private int userId;
	
	@Size(min = 6, message ="Enter at least 6 characters")
	@Column (name ="Description")
	private String desc;
	
	@Column (name ="TargetDate")
	private Date targetDate;
	
	@Column (name ="IsDone")
	private boolean isDone;
	
	//Default Constructor
	public Todo()
	{
		
	}
	public Todo(int id, int userId, String desc, Date targetDate,
			boolean isDone) {
		super();
		this.id = id;
		this.userId = userId;
		this.desc = desc;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUser(int userId) {
		this.userId = userId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return String.format(
				"Todo [id=%s, user=%s, desc=%s, targetDate=%s, isDone=%s]", id,
				userId, desc, targetDate, isDone);
	}


}
