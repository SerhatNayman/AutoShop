package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.autoshop.Models.RegisterPojo;
import com.example.autoshop.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    EditText user, pass;
    Button kayit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tanimla();
    }

    public void tanimla() {

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        kayit = findViewById(R.id.kayit);

        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String uye = user.getText().toString();
                String sifre = pass.getText().toString();

                register(uye, sifre);


            }
        });


    }

    public void register(final String kullanici, String parola) {

        Call<RegisterPojo> ekle = ManagerAll.getInstance().register(kullanici, parola);

        ekle.enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {

                if (response.isSuccessful()) {

                    String uye = user.getText().toString();


                    if (!user.getText().toString().equals("") && !pass.getText().toString().equals("")) {

                        if (response.body().isTf()) {

                            Toast.makeText(getApplicationContext(), response.body().getResult(), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, Dogrulama.class);
                            intent.putExtra("uyeadi", uye);
                            intent.putExtra("dogrulamakodu", response.body().getDogrulamaKodu().toString());
                            startActivity(intent);
                        }
                    }
                    else
                    {

                        Toast.makeText(getApplicationContext(),"Lütfen Boş Alanları Doldurunuz!",Toast.LENGTH_LONG).show();

                    }

                }
            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {


            }
        });


    }
}