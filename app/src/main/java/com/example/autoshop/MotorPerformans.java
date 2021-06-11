package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.autoshop.Models.IlanVerPojo;

public class MotorPerformans extends AppCompatActivity {
    EditText motorTipi, motorHacmi, azamiSurat;
    Button motorileri, geri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motor_performans);
        tanimla();
    }

    public void tanimla() {


        motorTipi = findViewById(R.id.motorTipi);
        motorHacmi = findViewById(R.id.motorhacim);
        azamiSurat = findViewById(R.id.azamisurat);


        motorTipi.setText(IlanVerPojo.getMotortipi());
        motorHacmi.setText(IlanVerPojo.getMotorhacmi());
        azamiSurat.setText(IlanVerPojo.getSurat());


        motorileri = findViewById(R.id.motorPerformansileri);
        geri = findViewById(R.id.motorPerformansilerigeri);


        motorileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!motorTipi.getText().toString().equals("") && !motorHacmi.getText().toString().equals("") && !azamiSurat.getText().toString().equals("")) {

                    IlanVerPojo.setMotortipi(motorTipi.getText().toString());
                    IlanVerPojo.setMotorhacmi(motorHacmi.getText().toString());
                    IlanVerPojo.setSurat(azamiSurat.getText().toString());

                    Intent intent = new Intent(MotorPerformans.this, YakitTuketimi.class);
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

                Intent intent = new Intent(MotorPerformans.this, AracBilgileri.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_in_ters, R.anim.anim_out_ters);
                finish();
            }
        });


    }
}