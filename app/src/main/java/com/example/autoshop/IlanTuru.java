package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.autoshop.Models.IlanVerPojo;

import java.util.ArrayList;
import java.util.List;

public class IlanTuru extends AppCompatActivity {

    Button itileri,itgeri;
    Spinner ilanturu,kimden;
    List<String> turList,sahibindenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_turu);
        listeDoldur();
        tanimla();
    }
    public void tanimla(){


        ilanturu = findViewById(R.id.ilanTuru);
        kimden = findViewById(R.id.kimden);

        ArrayAdapter<String> turListAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,turList);
        turListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ilanturu.setAdapter(turListAdapter);

        ArrayAdapter<String> sahipListAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,sahibindenList);
        sahipListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kimden.setAdapter(sahipListAdapter);


        itgeri = findViewById(R.id.itgeri);
        itileri = findViewById(R.id.itileri);

        itgeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(IlanTuru.this,ilanBilgileri.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_in_ters,R.anim.anim_out_ters);
                finish();

            }
        });
        itileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IlanVerPojo.setKimden(kimden.getSelectedItem().toString());
                IlanVerPojo.setIlantipi(ilanturu.getSelectedItem().toString());


                Intent intent = new Intent(IlanTuru.this,AdresBilgileri.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                finish();
            }
        });

    }

    public void listeDoldur(){

        turList = new ArrayList<>();
        sahibindenList = new ArrayList<>();
        turList.add("Satılık");
        sahibindenList.add("Sahibinden");
        sahibindenList.add("Auto Galeriden");


    }
}