package com.example.autoshop.Models;

public class RegisterPojo{
	private String result;
	private boolean tf;
	private Integer dogrulamaKodu;

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

	public void setDogrulamaKodu(Integer dogrulamaKodu){
		this.dogrulamaKodu = dogrulamaKodu;
	}

	public Integer getDogrulamaKodu(){
		return dogrulamaKodu;
	}

	@Override
 	public String toString(){
		return 
			"RegisterPojo{" + 
			"result = '" + result + '\'' + 
			",tf = '" + tf + '\'' + 
			",dogrulamaKodu = '" + dogrulamaKodu + '\'' + 
			"}";
		}
}
