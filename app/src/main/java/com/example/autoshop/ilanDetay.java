package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.autoshop.Adapters.SliderAdapter;
import com.example.autoshop.Models.FavoriIslemPojo;
import com.example.autoshop.Models.FavoriPojo;
import com.example.autoshop.Models.IlanDetayPojo;
import com.example.autoshop.Models.IlanVerPojo;
import com.example.autoshop.Models.SliderPojo;
import com.example.autoshop.RestApi.ManagerAll;

import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.String.valueOf;

public class ilanDetay extends AppCompatActivity {

    private TextView uyeadi, ilanBaslik, ilanKimden, ilanMarka, ilanModel, ilanKilometre, ilanFiyat, ilanYil, ilanMotorTipi, ilanMotorHacmi, ilanSurat, ilanYakitTipi, ilanOrtalamaYakit, ilanDepoHacmi, ilanTipi, ilanAciklama;
    private Button ilanAra, ilanMesaj, ilanFavori;
    private ViewPager ilanDetaySlider;
    private TextView sehir, ilce, mahalle;
    String ilanId,UyeID,otherId; // ilan id'isi aldik.
    List<SliderPojo> list;
    SliderAdapter adp;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_detay);
        Bundle bundle = getIntent().getExtras();
        ilanId = bundle.getString("ilanid");  // ilan id'mizi aldik.


        sharedPreferences = getApplicationContext().getSharedPreferences("giris", 0);
        IlanVerPojo.setUye_id(sharedPreferences.getString("uyeid", null));
        UyeID = sharedPreferences.getString("uyeid", null);


        tanimla();
        getIlanDetay();
        getResim();
        getText();
        tiklama();
    }


    public void tanimla() {

        uyeadi = findViewById(R.id.IlanDetayUser);
        ilanBaslik = findViewById(R.id.IlanDetayBaslik);
        ilanKimden = findViewById(R.id.IlanDetayKimden);
        ilanMarka = findViewById(R.id.IlanDetayMarka);
        ilanModel = findViewById(R.id.IlanDetayModel);
        ilanKilometre = findViewById(R.id.IlanDetayKilometre);
        ilanFiyat = findViewById(R.id.IlanDetayFiyat);
        ilanYil = findViewById(R.id.IlanDetayYil);
        ilanMotorTipi = findViewById(R.id.IlanDetayMotorTipi);
        ilanMotorHacmi = findViewById(R.id.IlanDetayMotorHacmi);
        ilanSurat = findViewById(R.id.IlanDetaySurat);
        ilanYakitTipi = findViewById(R.id.IlanDetayYakitTipi);
        ilanOrtalamaYakit = findViewById(R.id.IlanDetayOrtalamaYakit);
        ilanDepoHacmi = findViewById(R.id.IlanDetayDepoHacmi);
        ilanTipi = findViewById(R.id.IlanDetayIlanTipi);
        ilanAciklama = findViewById(R.id.IlanDetayAciklama);
        ilanAra = findViewById(R.id.IlanDetayara);
        ilanMesaj = findViewById(R.id.IlanDetaymesaj);
        ilanFavori = findViewById(R.id.IlanDetayFavori);
        ilanDetaySlider = findViewById(R.id.IlanDetaySlider);
        sehir = findViewById(R.id.IlanDetaysehir);
        ilce = findViewById(R.id.IlanDetayilce);
        mahalle = findViewById(R.id.IlanDetaymahalle);
        ilanFavori = findViewById(R.id.IlanDetayFavori);


    }


    public void getIlanDetay() {

        Call<IlanDetayPojo> request = ManagerAll.getInstance().IlanDetay(ilanId);
        request.enqueue(new Callback<IlanDetayPojo>() {
            @Override
            public void onResponse(Call<IlanDetayPojo> call, Response<IlanDetayPojo> response) {


                ilanBaslik.setText(response.body().getBaslik());
                ilanKimden.setText(response.body().getKimden());
                ilanMarka.setText(response.body().getMarka());
                ilanModel.setText(response.body().getModel());
                ilanKilometre.setText(response.body().getKilometre());
                ilanFiyat.setText(response.body().getFiyat());
                ilanYil.setText(response.body().getYil());
                ilanMotorTipi.setText(response.body().getMotortipi());
                ilanMotorHacmi.setText(response.body().getMotorhacmi());
                ilanSurat.setText(response.body().getSurat());
                ilanYakitTipi.setText(response.body().getYakittipi());
                ilanOrtalamaYakit.setText(response.body().getOrtalamayakit());
                ilanDepoHacmi.setText(response.body().getDepohacmi());
                ilanTipi.setText(response.body().getIlantipi());
                ilanAciklama.setText(response.body().getAciklama());
                sehir.setText(response.body().getSehir());
                ilce.setText(response.body().getIlce());
                mahalle.setText(response.body().getMahalle());
                uyeadi.setText(response.body().getUyeadi());
                otherId = response.body().getUyeid();


            }

            @Override
            public void onFailure(Call<IlanDetayPojo> call, Throwable t) {

            }
        });


    }

    public void getResim() {


        Call<List<SliderPojo>> request = ManagerAll.getInstance().ilanResimleri(ilanId);
        request.enqueue(new Callback<List<SliderPojo>>() {
            @Override
            public void onResponse(Call<List<SliderPojo>> call, Response<List<SliderPojo>> response) {

                list = response.body();
                adp = new SliderAdapter(list, getApplicationContext());
                ilanDetaySlider.setAdapter(adp);


            }

            @Override
            public void onFailure(Call<List<SliderPojo>> call, Throwable t) {

            }
        });


    }

    public void getText() {


        Call<FavoriPojo> request = ManagerAll.getInstance().getButonText(UyeID, ilanId);
        request.enqueue(new Callback<FavoriPojo>() {
            @Override
            public void onResponse(Call<FavoriPojo> call, Response<FavoriPojo> response) {


                if (response.body().isTf()) {

                    ilanFavori.setText(response.body().getText());

                } else {

                    ilanFavori.setText(response.body().getText());

                }


            }

            @Override
            public void onFailure(Call<FavoriPojo> call, Throwable t) {

            }
        });


    }

    public void tiklama() {


        ilanFavori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<FavoriIslemPojo> request = ManagerAll.getInstance().favoriIslem(UyeID, ilanId);
                request.enqueue(new Callback<FavoriIslemPojo>() {
                    @Override
                    public void onResponse(Call<FavoriIslemPojo> call, Response<FavoriIslemPojo> response) {

                        if (response.body().isTf()) {

                            Toast.makeText(getApplicationContext(), response.body().getText(), Toast.LENGTH_LONG).show();

                            getText();

                        } else {
                            Toast.makeText(getApplicationContext(), response.body().getText(), Toast.LENGTH_LONG).show();

                            getText();
                        }


                    }

                    @Override
                    public void onFailure(Call<FavoriIslemPojo> call, Throwable t) {


                    }
                });

            }
        });
        ilanMesaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ilanDetay.this,MessageActivity.class);
                OtherId.setOtherId(otherId);
                startActivity(intent);

            }
        });


    }

}