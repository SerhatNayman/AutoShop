package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.autoshop.Models.DogrulamaPojo;
import com.example.autoshop.Models.RegisterPojo;
import com.example.autoshop.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dogrulama extends AppCompatActivity {

    EditText KodDogrula;
    EditText kullaniciAdi;
    Button DogrulamaButton;
    String dogrulamaKodu;
    String kullaniciIsmi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogrulama);
        tanimla();
        kodGir();

    }

    public void tanimla() {

        kullaniciAdi = findViewById(R.id.kullanicidogrula);
        KodDogrula = findViewById(R.id.dogrulamakod);
        DogrulamaButton = findViewById(R.id.dogrulabtn);


        DogrulamaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String user = kullaniciAdi.getText().toString();
                String code = KodDogrula.getText().toString();
                dogrula(user, code);

                Toast.makeText(getApplicationContext(),"Üyeliğiniz Aktif Edilmiştir. Giriş Yapabilirsiniz.",Toast.LENGTH_LONG).show();
                if (code.equals(dogrulamaKodu)) {


                    Intent intent = new Intent(Dogrulama.this, Login.class);
                    startActivity(intent);

                }
            }
        });


    }

    public void kodGir() {


        Bundle bundle = getIntent().getExtras();
        dogrulamaKodu = bundle.getString("dogrulamakodu");
        kullaniciIsmi = bundle.getString("uyeadi");

        kullaniciAdi.setText(kullaniciIsmi);
        KodDogrula.setText(dogrulamaKodu);





    }

    public void dogrula(String username, String code) {


        Call<DogrulamaPojo> dogrula = ManagerAll.getInstance().dogrula(username, code);
        dogrula.enqueue(new Callback<DogrulamaPojo>() {
            @Override
            public void onResponse(Call<DogrulamaPojo> call, Response<DogrulamaPojo> response) {


                if (response.body().isTf()) {



                    Toast.makeText(getApplicationContext(), response.body().getResult(), Toast.LENGTH_SHORT).show();


                }


            }

            @Override
            public void onFailure(Call<DogrulamaPojo> call, Throwable t) {

            }
        });


    }
}