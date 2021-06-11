package com.example.autoshop.Models.Models;

public class IlanlarPojo {

    private String result;
    private String resim;
    private boolean tf;
    private Object uyeid;
    private String ilanid;
    private String fiyat;
    private int sayi;
    private String baslik;
    private String sehir;
    private String ilce;
    private String mahalle;
    private String aciklama;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public boolean isTf() {
        return tf;
    }

    public void setTf(boolean tf) {
        this.tf = tf;
    }

    public Object getUyeid() {
        return uyeid;
    }

    public void setUyeid(Object uyeid) {
        this.uyeid = uyeid;
    }

    public String getIlanid() {
        return ilanid;
    }

    public void setIlanid(String ilanid) {
        this.ilanid = ilanid;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public int getSayi() {
        return sayi;
    }

    public void setSayi(int sayi) {
        this.sayi = sayi;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public String toString() {
        return "IlanlarPojo{" +
                "result='" + result + '\'' +
                ", resim='" + resim + '\'' +
                ", tf=" + tf +
                ", uyeid=" + uyeid +
                ", ilanid='" + ilanid + '\'' +
                ", fiyat='" + fiyat + '\'' +
                ", sayi=" + sayi +
                ", baslik='" + baslik + '\'' +
                ", sehir='" + sehir + '\'' +
                ", ilce='" + ilce + '\'' +
                ", mahalle='" + mahalle + '\'' +
                ", aciklama='" + aciklama + '\'' +
                '}';
    }
}
