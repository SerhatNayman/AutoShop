package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.autoshop.Models.IlanVerPojo;

public class AracBilgileri extends AppCompatActivity {

    EditText marka, model, motor, yil, kilometre;
    Button ileri, geri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_bilgileri);
        tanimla();
    }

    public void tanimla() {


        marka = findViewById(R.id.marka);
        model = findViewById(R.id.model);
        yil = findViewById(R.id.yil);
        kilometre = findViewById(R.id.kilometre);


        marka.setText(IlanVerPojo.getMarka());
        model.setText(IlanVerPojo.getModel());
        yil.setText(IlanVerPojo.getYil());
        kilometre.setText(IlanVerPojo.getKilometre());


        ileri = findViewById(R.id.aracBilgileribtn);
        geri = findViewById(R.id.aracBilgileribtngeri);

        ileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!marka.getText().toString().equals("") && !model.getText().toString().equals("") &&
                        !yil.getText().toString().equals("") && !kilometre.getText().toString().equals("")) {

                    IlanVerPojo.setMarka(marka.getText().toString());
                    IlanVerPojo.setModel(model.getText().toString());
                    IlanVerPojo.setYil(yil.getText().toString());
                    IlanVerPojo.setKilometre(kilometre.getText().toString());


                    Intent intent = new Intent(AracBilgileri.this, MotorPerformans.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
                    finish();
                } else {

                    Toast.makeText(getApplicationContext(), "Lütfen Bilgileri Doldurunuz", Toast.LENGTH_SHORT).show();

                }
            }
        });

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AracBilgileri.this, AdresBilgileri.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_in_ters, R.anim.anim_out_ters);
                finish();
            }
        });

    }
}