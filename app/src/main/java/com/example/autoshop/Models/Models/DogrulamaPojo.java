package com.example.autoshop.Models.Models;

public class DogrulamaPojo{
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
			"DogrulamaPojo{" + 
			"result = '" + result + '\'' + 
			",tf = '" + tf + '\'' + 
			"}";
		}
}
