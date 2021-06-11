package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.autoshop.Adapters.FavoriSliderAdapter;
import com.example.autoshop.Adapters.SliderAdapter;
import com.example.autoshop.Models.FavoriSliderPojo;
import com.example.autoshop.Models.IlanVerPojo;
import com.example.autoshop.RestApi.ManagerAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageButton ilanlar, ilanver, favorim, iletisim, mesajlarim, ilanlarim;
    ImageView exit;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ViewPager slider;
    String uyeId;
    FavoriSliderAdapter favoriSliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getApplicationContext().getSharedPreferences("giris", 0);
        IlanVerPojo.setUye_id(sharedPreferences.getString("uyeid", null));
        uyeId = sharedPreferences.getString("uyeid", null);
        tanimla();
        exit();
        tikla();
        getSlider();
    }

    public void exit() {


        exit = findViewById(R.id.cikis);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cikis();

            }
        });


    }

    public void cikis() {

        editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);


    }

    public void tanimla() {


        ilanlar = findViewById(R.id.img1);
        ilanver = findViewById(R.id.img2);
        favorim = findViewById(R.id.img3);
        iletisim = findViewById(R.id.img4);
        mesajlarim = findViewById(R.id.img5);
        ilanlarim = findViewById(R.id.img6);
        slider = findViewById(R.id.Mainslider);


    }

    public void tikla() {
        ilanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ilanlar.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);


            }
        });


        ilanver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ilanBilgileri.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);


            }
        });
        favorim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
            }
        });
        iletisim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(MainActivity.this,BilgilerActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
            }
        });
        mesajlarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MesajlarimActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);


            }
        });
        ilanlarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ilanlarim.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
            }
        });


    }
    public void getSlider()
    {
        Call<List<FavoriSliderPojo>> request = ManagerAll.getInstance().setSlider(uyeId);
        request.enqueue(new Callback<List<FavoriSliderPojo>>() {
            @Override
            public void onResponse(Call<List<FavoriSliderPojo>> call, Response<List<FavoriSliderPojo>> response) {

                if (response.body().get(0).isTf())
                {

                    if (response.body().size()>0) {
                        favoriSliderAdapter = new FavoriSliderAdapter(response.body(), MainActivity.this, MainActivity.this);
                        slider.setAdapter(favoriSliderAdapter);
                    }




                }
                else
                {
                    favoriSliderAdapter = new FavoriSliderAdapter(response.body(), MainActivity.this, MainActivity.this);
                    slider.setAdapter(favoriSliderAdapter);




                }

            }

            @Override
            public void onFailure(Call<List<FavoriSliderPojo>> call, Throwable t) {

            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        getSlider();
    }
}