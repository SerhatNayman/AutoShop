package com.example.autoshop.Models.Models;

public class Response{
	private boolean tf;
	private String uyeid;
	private String ilanid;

	public void setTf(boolean tf){
		this.tf = tf;
	}

	public boolean isTf(){
		return tf;
	}

	public void setUyeid(String uyeid){
		this.uyeid = uyeid;
	}

	public String getUyeid(){
		return uyeid;
	}

	public void setIlanid(String ilanid){
		this.ilanid = ilanid;
	}

	public String getIlanid(){
		return ilanid;
	}
}
