package com.example.autoshop.Models;

public class IlanDetayPojo{
	private String ortalamayakit;
	private String fiyat;
	private String surat;
	private String mahalle;
	private String motorhacmi;
	private String kimden;
	private String aciklama;
	private String ilce;
	private String uyeid;
	private String yakittipi;
	private String ilantipi;
	private String marka;
	private String model;
	private String sehir;
	private String depohacmi;
	private String motortipi;
	private String yil;
	private String baslik;
	private String kilometre;
	private String uyeadi;

	public String getUyeadi() {
		return uyeadi;
	}

	public void setUyeadi(String uyeadi) {
		this.uyeadi = uyeadi;
	}

	public void setOrtalamayakit(String ortalamayakit){
		this.ortalamayakit = ortalamayakit;
	}

	public String getOrtalamayakit(){
		return ortalamayakit;
	}

	public void setFiyat(String fiyat){
		this.fiyat = fiyat;
	}

	public String getFiyat(){
		return fiyat;
	}

	public void setSurat(String surat){
		this.surat = surat;
	}

	public String getSurat(){
		return surat;
	}

	public void setMahalle(String mahalle){
		this.mahalle = mahalle;
	}

	public String getMahalle(){
		return mahalle;
	}

	public void setMotorhacmi(String motorhacmi){
		this.motorhacmi = motorhacmi;
	}

	public String getMotorhacmi(){
		return motorhacmi;
	}

	public void setKimden(String kimden){
		this.kimden = kimden;
	}

	public String getKimden(){
		return kimden;
	}

	public void setAciklama(String aciklama){
		this.aciklama = aciklama;
	}

	public String getAciklama(){
		return aciklama;
	}

	public void setIlce(String ilce){
		this.ilce = ilce;
	}

	public String getIlce(){
		return ilce;
	}

	public void setUyeid(String uyeid){
		this.uyeid = uyeid;
	}

	public String getUyeid(){
		return uyeid;
	}

	public void setYakittipi(String yakittipi){
		this.yakittipi = yakittipi;
	}

	public String getYakittipi(){
		return yakittipi;
	}

	public void setIlantipi(String ilantipi){
		this.ilantipi = ilantipi;
	}

	public String getIlantipi(){
		return ilantipi;
	}

	public void setMarka(String marka){
		this.marka = marka;
	}

	public String getMarka(){
		return marka;
	}

	public void setModel(String model){
		this.model = model;
	}

	public String getModel(){
		return model;
	}

	public void setSehir(String sehir){
		this.sehir = sehir;
	}

	public String getSehir(){
		return sehir;
	}

	public void setDepohacmi(String depohacmi){
		this.depohacmi = depohacmi;
	}

	public String getDepohacmi(){
		return depohacmi;
	}

	public void setMotortipi(String motortipi){
		this.motortipi = motortipi;
	}

	public String getMotortipi(){
		return motortipi;
	}

	public void setYil(String yil){
		this.yil = yil;
	}

	public String getYil(){
		return yil;
	}

	public void setBaslik(String baslik){
		this.baslik = baslik;
	}

	public String getBaslik(){
		return baslik;
	}

	public void setKilometre(String kilometre){
		this.kilometre = kilometre;
	}

	public String getKilometre(){
		return kilometre;
	}

	@Override
 	public String toString(){
		return 
			"IlanDetayPojo{" + 
			"ortalamayakit = '" + ortalamayakit + '\'' + 
			",fiyat = '" + fiyat + '\'' + 
			",surat = '" + surat + '\'' + 
			",mahalle = '" + mahalle + '\'' + 
			",motorhacmi = '" + motorhacmi + '\'' + 
			",kimden = '" + kimden + '\'' + 
			",aciklama = '" + aciklama + '\'' + 
			",ilce = '" + ilce + '\'' + 
			",uyeid = '" + uyeid + '\'' + 
			",yakittipi = '" + yakittipi + '\'' + 
			",ilantipi = '" + ilantipi + '\'' + 
			",marka = '" + marka + '\'' + 
			",model = '" + model + '\'' + 
			",sehir = '" + sehir + '\'' + 
			",depohacmi = '" + depohacmi + '\'' + 
			",motortipi = '" + motortipi + '\'' + 
			",yil = '" + yil + '\'' + 
			",baslik = '" + baslik + '\'' + 
			",kilometre = '" + kilometre + '\'' + 
			"}";
		}
}
