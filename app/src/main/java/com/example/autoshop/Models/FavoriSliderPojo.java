package com.example.autoshop.Models;

public class FavoriSliderPojo{
	private Object resimyolu;
	private boolean tf;
	private Object ilanid;

	public void setResimyolu(Object resimyolu){
		this.resimyolu = resimyolu;
	}

	public Object getResimyolu(){
		return resimyolu;
	}

	public void setTf(boolean tf){
		this.tf = tf;
	}

	public boolean isTf(){
		return tf;
	}

	public void setIlanid(Object ilanid){
		this.ilanid = ilanid;
	}

	public Object getIlanid(){
		return ilanid;
	}

	@Override
 	public String toString(){
		return 
			"FavoriSliderPojo{" + 
			"resimyolu = '" + resimyolu + '\'' + 
			",tf = '" + tf + '\'' + 
			",ilanid = '" + ilanid + '\'' + 
			"}";
		}
}
