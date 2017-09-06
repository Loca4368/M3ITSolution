package com.m3itsolution.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@NotEmpty
	//@Size(min = 6, max = 15, message ="Enter at least 6 characters")
	//@Column (name ="username", unique = true)
	@Column (name ="username")
	private String username;
	
	//@NotEmpty
	//@Size(min = 6, max = 15, message ="Enter at least 6 characters")
	@Column (name ="pwd")
	private String pwd;
	
	@Transient
    private String confirmPwd;
	
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn (name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
//	public User(Integer id, String username, String pwd)
//    {
//        this.id = id;
//        this.username = username;
//        this.pwd = pwd;
//    }
	public String getConfirmPwd() {
		return confirmPwd;
	}
	
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
	
//	@Override
//    public String toString()
//    {
//        return "User [ID=" + id + ", Name=" + username + ", pwd=" + pwd + "]";
//    }
	
}
