package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.autoshop.Models.LoginPojo;
import com.example.autoshop.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText user, pass;
    Button gir;
    TextView yeniHesap;
    SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tanimla();
        HesapTikla();

        preferences = getApplicationContext().getSharedPreferences("giris",0);
        if (preferences.getString("uyeid",null)!=null && preferences.getString("kullaniciAdi",null)!=null) {

            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void tanimla() {

        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        gir = findViewById(R.id.button);
        yeniHesap = findViewById(R.id.kayit);
        gir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String kullanici = user.getText().toString();
                String parola = pass.getText().toString();

                kontrol(kullanici, parola);


            }
        });


    }

    public void kontrol(String user, String pass) {

        Call<LoginPojo> ekle = ManagerAll.getInstance().add(user, pass);
        ekle.enqueue(new Callback<LoginPojo>() {
            @Override
            public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {

                if (response.isSuccessful()) {

                    if (response.body().getId() != null && response.body().getUsername() != null && response.body().getDurum().equals("1")) {

                        String uye_Id = response.body().getId().toString();               //3
                        String kullaniciAdi = response.body().getUsername().toString();   //4

                        preferences = getApplicationContext().getSharedPreferences("giris",0);  // beni hatirla  1
                        SharedPreferences.Editor editor = preferences.edit();  // tekrar giris yapmadan beni hatirla yapacak. 2
                        editor.putString("uyeid",uye_Id);  //5
                        editor.putString("kullaniciAdi",kullaniciAdi); //6
                        editor.commit(); //7

                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);


                    }


                }

            }

            @Override
            public void onFailure(Call<LoginPojo> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Kullanıcı adı veya Parola Yanlış!",Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void HesapTikla() {

        yeniHesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);

            }
        });


    }

}