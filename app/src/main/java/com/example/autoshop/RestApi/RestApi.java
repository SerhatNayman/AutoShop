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
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginPojo> addUser (@Field("username")String username, @Field("password")String password);

    @FormUrlEncoded
    @POST("kayitol.php")
    Call<RegisterPojo> register(@Field("username")String username,@Field("password")String password);


    @FormUrlEncoded
    @POST("dogrulama.php")
    Call<DogrulamaPojo> dogrulama(@Field("username")String username,@Field("dogrulamakodu")String DogrulamaKodu);

    @FormUrlEncoded
    @POST("ilanver.php")
    Call<IlanSonucPojo> ilanVer(@Field("uye_id") String uye_id,@Field("sehir")String sehir,@Field("ilce")String ilce,@Field("mahalle")String mahalle,
                                @Field("marka") String marka,@Field("model")String model,@Field("yil")String yil,@Field("ilantipi")String ilantipi,
                                @Field("kimden")String kimden,@Field("ilanbaslik")String ilanbaslik,@Field("ilanaciklama")String ilanaciklama,
                                @Field("motortipi")String motortipi,@Field("motorhacmi")String motorhacmi,@Field("surat")String surat,
                                @Field("yakittipi")String yakittipi,@Field("ortalamayakit")String ortalamayakit,@Field("depohacmi")String depohacmi,
                                @Field("kilometre")String kilometre,@Field("fiyat")String fiyat);




    @FormUrlEncoded
    @POST("ilanresmiekle.php")
    Call<ResimEklePojo> resimYukle(@Field("uye_id")String uye_id, @Field("ilan_id")String ilan_id, @Field("resim")String base64StringResim);


    @GET("ilanlarim.php")
    Call<List<IlanlarimPojo>> ilanlarim(@Query("uyeid")String uyeid);

    @GET("ilanlarimdansil.php")
    Call<IlanlarimSilPojo> ilanSil(@Query("ilan_id")String ilanid);

    @GET("ilanlar.php")
    Call<List<IlanlarPojo>> ilanlar();

    @GET("ilandetay2.php")
    Call<IlanDetayPojo> ilanDetay(@Query("ilanid")String ilanid);


    @GET("ilanresimleri.php")
    Call<List<SliderPojo>> ilanResimleri(@Query("ilanid")String ilanid);

    @GET("favori.php")
    Call<FavoriPojo> getButonText(@Query("uye_id")String uyeId,@Query("ilan_id")String ilanId);

    @GET("favoriislem.php")
    Call<FavoriIslemPojo> FavoriIslem(@Query("uye_id")String uyeId, @Query("ilan_id")String ilanId);

    @GET("favorislider.php")
    Call<List<FavoriSliderPojo>> setSlider (@Query("uye_id")String uyeid);

    @GET("bilgiler.php")
    Call<BilgilerPojo> Bilgiler (@Query("uye_id")String uyeid);

    @GET("bilgileriguncelle.php")
    Call<BilgiGuncellePojo> Update (@Query("uye_id")String uyeid,@Query("username")String username,@Query("password")String password);
}
