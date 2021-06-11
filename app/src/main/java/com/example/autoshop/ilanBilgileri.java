package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.autoshop.Models.IlanVerPojo;

public class ilanBilgileri extends AppCompatActivity {
    EditText baslik, aciklama,fiyat;
    Button tikla, geri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_bilgileri);
        tanimla();
    }

    public void tanimla() {

        baslik = findViewById(R.id.ilanBaslik);
        aciklama = findViewById(R.id.ilanAciklama);
        fiyat = findViewById(R.id.fiyat);
        tikla = findViewById(R.id.ilanBilgibtn);
        geri = findViewById(R.id.ilanBilgigeribtn);


        baslik.setText(IlanVerPojo.getIlanbaslik());
        aciklama.setText(IlanVerPojo.getIlanaciklama());
        fiyat.setText(IlanVerPojo.getFiyat());

        tikla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!baslik.getText().toString().equals("") && !aciklama.getText().toString().equals("") && !fiyat.getText().toString().equals("")) {

                    IlanVerPojo.setIlanbaslik(baslik.getText().toString());
                    IlanVerPojo.setIlanaciklama(aciklama.getText().toString());
                    IlanVerPojo.setFiyat(fiyat.getText().toString());
                    Intent intent = new Intent(ilanBilgileri.this, IlanTuru.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_in, R.anim.anim_out  );
                    finish();
                } else {

                    Toast.makeText(getApplicationContext(), "Tüm Bilgileri Girin", Toast.LENGTH_SHORT).show();

                }


            }
        });
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IlanVerPojo.setIlanbaslik("");
                IlanVerPojo.setIlanaciklama("");
                IlanVerPojo.setFiyat("");

                Intent intent = new Intent(ilanBilgileri.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_in_ters, R.anim.anim_out_ters);
                finish();
            }
        });

    }
}