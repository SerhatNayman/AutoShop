package com.example.autoshop.Models;

public class BilgiGuncellePojo{
	private boolean tf;

	public void setTf(boolean tf){
		this.tf = tf;
	}

	public boolean isTf(){
		return tf;
	}

	@Override
 	public String toString(){
		return 
			"BilgiGuncellePojo{" + 
			"tf = '" + tf + '\'' + 
			"}";
		}
}
