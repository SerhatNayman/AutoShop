package com.example.autoshop.Models;

public class LoginPojo{
	private Object durum;
	private Object id;
	private Object username;

	public void setDurum(Object durum){
		this.durum = durum;
	}

	public Object getDurum(){
		return durum;
	}

	public void setId(Object id){
		this.id = id;
	}

	public Object getId(){
		return id;
	}

	public void setUsername(Object username){
		this.username = username;
	}

	public Object getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"LoginPojo{" + 
			"durum = '" + durum + '\'' + 
			",id = '" + id + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}
