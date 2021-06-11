package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.autoshop.Models.IlanVerPojo;

public class AdresBilgileri extends AppCompatActivity {

    EditText sehir, ilce, mahalle;
    Button ileri, geri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adres_bilgileri);
        tanimla();
    }

    public void tanimla() {

        sehir = findViewById(R.id.sehir);
        ilce = findViewById(R.id.ilce);
        mahalle = findViewById(R.id.mahalle);

        sehir.setText(IlanVerPojo.getSehir());
        ilce.setText(IlanVerPojo.getIlce());
        mahalle.setText(IlanVerPojo.getMahalle());


        ileri = findViewById(R.id.yayinlabtn);
        geri = findViewById(R.id.yayinlabtngeri);

        ileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!sehir.getText().toString().equals("") && !ilce.getText().toString().equals("") && !mahalle.getText().toString().equals("")) {

                    IlanVerPojo.setSehir(sehir.getText().toString());
                    IlanVerPojo.setIlce(ilce.getText().toString());
                    IlanVerPojo.setMahalle(mahalle.getText().toString());

                    Intent intent = new Intent(AdresBilgileri.this, AracBilgileri.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                    finish();

                } else {

                    Toast.makeText(getApplicationContext(), "Lütfen Bilgileri Giriniz", Toast.LENGTH_SHORT).show();

                }


            }
        });
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdresBilgileri.this, IlanTuru.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_in_ters, R.anim.anim_out_ters);
                finish();
            }
        });

    }


}