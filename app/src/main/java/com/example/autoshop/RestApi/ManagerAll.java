package com.example.autoshop.RestApi;

import com.example.autoshop.Models.BilgiGuncellePojo;
import com.example.autoshop.Models.BilgilerPojo;
import com.example.autoshop.Models.DogrulamaPojo;
import com.example.autoshop.Models.FavoriIslemPojo;
import com.example.autoshop.Models.FavoriPojo;
import com.example.autoshop.Models.FavoriSliderPojo;
import com.example.autoshop.Models.IlanDetayPojo;
import com.example.autoshop.Models.IlanSonucPojo;
import com.example.autoshop.Models.IlanlarPojo;
import com.example.autoshop.Models.IlanlarimPojo;
import com.example.autoshop.Models.IlanlarimSilPojo;
import com.example.autoshop.Models.LoginPojo;
import com.example.autoshop.Models.RegisterPojo;
import com.example.autoshop.Models.ResimEklePojo;
import com.example.autoshop.Models.SliderPojo;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance() {

        return ourInstance;

    }

    public Call<LoginPojo> add(String username, String password) {

        Call<LoginPojo> x = getRestApi().addUser(username, password);
        return x;


    }

    public Call<RegisterPojo> register(String username, String password) {

        Call<RegisterPojo> x = getRestApi().register(username, password);
        return x;


    }

    public Call<DogrulamaPojo> dogrula(String user, String code) {

        Call<DogrulamaPojo> x = getRestApi().dogrulama(user, code);
        return x;


    }

    public Call<IlanSonucPojo> ilanVer(String uye_id, String sehir, String ilce, String mahalle, String marka, String model, String yil, String ilantipi,
                                       String kimden, String ilanbaslik, String ilanaciklama, String motortipi, String motorhacmi, String surat, String yakittipi,
                                       String ortalamayakit, String depohacmi, String kilometre,String fiyat) {

        Call<IlanSonucPojo> x = getRestApi().ilanVer(uye_id, sehir, ilce, mahalle, marka, model, yil, ilantipi, kimden, ilanbaslik, ilanaciklama, motortipi, motorhacmi, surat, yakittipi, ortalamayakit, depohacmi, kilometre,fiyat);
        return x;


    }

    public Call<ResimEklePojo> resimEkle(String uye_id, String ilan_id, String image) {

        Call<ResimEklePojo> x = getRestApi1().resimYukle(uye_id, ilan_id, image);
        return x;


    }
    public Call<List<IlanlarimPojo>> ilanlarim(String uyeid)
    {

        Call<List<IlanlarimPojo>> x = getRestApi().ilanlarim(uyeid);
        return x;


    }
    public Call<IlanlarimSilPojo> ilanSil(String ilanID)
    {

        Call<IlanlarimSilPojo> x = getRestApi().ilanSil(ilanID);
        return x;


    }

    public Call<List<IlanlarPojo>> ilanlar()
    {

        Call<List<IlanlarPojo>> x = getRestApi().ilanlar();
        return x;


    }

    public Call<IlanDetayPojo> IlanDetay(String ilanid)
    {

        Call<IlanDetayPojo> x = getRestApi().ilanDetay(ilanid);
        return x;


    }
    public Call<List<SliderPojo>> ilanResimleri(String ilanid){



       Call<List<SliderPojo>> x = getRestApi().ilanResimleri(ilanid);

       return x;

    }
    public Call<FavoriPojo> getButonText(String uyeid,String ilanid)
    {

        Call<FavoriPojo> x = getRestApi().getButonText(uyeid, ilanid);
        return x;


    }

    public Call<FavoriIslemPojo> favoriIslem(String uyeid,String ilanid)
    {

        Call<FavoriIslemPojo> x = getRestApi().FavoriIslem(uyeid, ilanid);
        return x;

    }
    public Call<List<FavoriSliderPojo>> setSlider(String uyeId)
    {

        Call<List<FavoriSliderPojo>> x = getRestApi().setSlider(uyeId);
        return x;


    }
    public Call<BilgilerPojo> Bilgiler(String uyeid)
    {
        Call<BilgilerPojo> x = getRestApi().Bilgiler(uyeid);
        return x;


    }
    public Call<BilgiGuncellePojo> update(String uyeid,String username,String password)
    {

        Call<BilgiGuncellePojo> x = getRestApi().Update(uyeid, username, password);
        return x;


    }
}
