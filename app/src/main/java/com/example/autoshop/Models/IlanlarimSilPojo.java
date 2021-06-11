package com.example.autoshop.Models;

public class IlanlarimSilPojo{
	private String result;
	private boolean tf;

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setTf(boolean tf){
		this.tf = tf;
	}

	public boolean isTf(){
		return tf;
	}

	@Override
 	public String toString(){
		return 
			"IlanlarimSilPojo{" + 
			"result = '" + result + '\'' + 
			",tf = '" + tf + '\'' + 
			"}";
		}
}
