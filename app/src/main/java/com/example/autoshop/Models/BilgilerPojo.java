package com.example.autoshop.Models;

public class BilgilerPojo{
	private String pass;
	private String user;

	public void setPass(String pass){
		this.pass = pass;
	}

	public String getPass(){
		return pass;
	}

	public void setUser(String user){
		this.user = user;
	}

	public String getUser(){
		return user;
	}

	@Override
 	public String toString(){
		return 
			"BilgilerPojo{" + 
			"pass = '" + pass + '\'' + 
			",user = '" + user + '\'' + 
			"}";
		}
}
