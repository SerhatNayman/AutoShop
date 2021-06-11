package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.autoshop.Models.IlanSonucPojo;
import com.example.autoshop.Models.IlanVerPojo;
import com.example.autoshop.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YakitTuketimi extends AppCompatActivity {
    EditText yakitTipi, ortalamaYakit, depoHacmi;
    Button yakitileri, geri;
    SharedPreferences sharedPreferences;
    String serosoft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yakit_tuketimi);
        tanimla();
    }

    public void tanimla() {

        sharedPreferences = getApplicationContext().getSharedPreferences("giris", 0);   // uye_id aldik.
        serosoft = sharedPreferences.getString("uyeid", null);
        IlanVerPojo.setUye_id(serosoft);// uye_id aldik.
        Log.i("UyeID :" ," "+serosoft);


        yakitTipi = findViewById(R.id.yakitTipi);
        ortalamaYakit = findViewById(R.id.ortalamaYakit);
        depoHacmi = findViewById(R.id.ortalamaYakit);

        yakitTipi.setText(IlanVerPojo.getYakittipi());
        ortalamaYakit.setText(IlanVerPojo.getOrtalamayakit());
        depoHacmi.setText(IlanVerPojo.getDepohacmi());

        yakitileri = findViewById(R.id.YTileri);
        geri = findViewById(R.id.YTgeri);

        yakitileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!yakitTipi.getText().toString().equals("") && !ortalamaYakit.getText().toString().equals("") && !depoHacmi.getText().toString().equals("")) {

                    IlanVerPojo.setYakittipi(yakitTipi.getText().toString());
                    IlanVerPojo.setOrtalamayakit(ortalamaYakit.getText().toString());
                    IlanVerPojo.setDepohacmi(depoHacmi.getText().toString());


                    ilanYayinla(IlanVerPojo.getUye_id(), IlanVerPojo.getSehir(), IlanVerPojo.getIlce(), IlanVerPojo.getMahalle(), IlanVerPojo.getMarka(), IlanVerPojo.getModel(),
                            IlanVerPojo.getYil(), IlanVerPojo.getIlantipi(), IlanVerPojo.getKimden(), IlanVerPojo.getIlanbaslik(), IlanVerPojo.getIlanaciklama(), IlanVerPojo.getMotortipi(),
                            IlanVerPojo.getMotorhacmi(), IlanVerPojo.getSurat(), IlanVerPojo.getYakittipi(), IlanVerPojo.getOrtalamayakit(), IlanVerPojo.getDepohacmi(), IlanVerPojo.getKilometre(), IlanVerPojo.getFiyat());


                } else {

                    Toast.makeText(getApplicationContext(), "Lütfen Bilgileri Giriniz", Toast.LENGTH_SHORT).show();

                }

            }

        });
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(YakitTuketimi.this, MotorPerformans.class);

                startActivity(intent);
                overridePendingTransition(R.anim.anim_in_ters, R.anim.anim_out_ters);
                finish();
            }
        });


    }

    public void ilanYayinla(String uye_id, String sehir, String ilce, String mahalle, String marka, String model, String yil, String ilantipi,
                            String kimden, String ilanbaslik, String ilanaciklama, String motortipi, String motorhacmi, String surat, String yakittipi,
                            String ortalamayakit, String depohacmi, String kilometre, String fiyat) {

        Call<IlanSonucPojo> ilanSonuc = ManagerAll.getInstance().ilanVer(uye_id, sehir, ilce, mahalle, marka, model, yil, ilantipi, kimden, ilanbaslik, ilanaciklama, motortipi, motorhacmi, surat, yakittipi, ortalamayakit, depohacmi, kilometre, fiyat);

        ilanSonuc.enqueue(new Callback<IlanSonucPojo>() {
            @Override
            public void onResponse(Call<IlanSonucPojo> call, Response<IlanSonucPojo> response) {


                if (response.body().isTf()) {

                    Intent intent = new Intent(YakitTuketimi.this, ilanResimler.class);
                    intent.putExtra("ilanid", response.body().getIlanid());   // ilan_id alip resimler sayfasina gonderdik.
                    intent.putExtra("uyeid", response.body().getUyeid());  // uye_id alip resimler sayfasina gonderdik.
                    Log.i("Test", response.body().getIlanid() + " // " + response.body().getUyeid());
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                    finish();


                }

            }

            @Override
            public void onFailure(Call<IlanSonucPojo> call, Throwable t) {

            }
        });


    }
}