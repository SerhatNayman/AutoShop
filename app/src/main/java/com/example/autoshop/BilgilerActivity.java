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

import com.example.autoshop.Models.BilgiGuncellePojo;
import com.example.autoshop.Models.BilgilerPojo;
import com.example.autoshop.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BilgilerActivity extends AppCompatActivity {
    EditText BilgilerPass;
    TextView BilgilerUser;
    Button BilgilerGuncelle,BilgilerGeri;
    SharedPreferences preferences;
    String uyeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgiler);
        tanimla();
        preferences = getApplicationContext().getSharedPreferences("giris", 0);
        uyeID = preferences.getString("uyeid", null);
        istekAt();

    }
    public void tanimla(){

        BilgilerUser = findViewById(R.id.BilgilerUser);
        BilgilerPass = findViewById(R.id.BilgilerPass);
        BilgilerGuncelle = findViewById(R.id.BilgilerGuncelle);
        BilgilerGeri = findViewById(R.id.BilgilerGeri);

        BilgilerGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Update(uyeID,BilgilerUser.getText().toString(),BilgilerPass.getText().toString());
            }
        });
        BilgilerGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(BilgilerActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
    public void istekAt(){

        Call<BilgilerPojo> request = ManagerAll.getInstance().Bilgiler(uyeID);
        request.enqueue(new Callback<BilgilerPojo>() {
            @Override
            public void onResponse(Call<BilgilerPojo> call, Response<BilgilerPojo> response) {

                if ((response.isSuccessful()))
                {

                    BilgilerUser.setText(response.body().getUser());
                    BilgilerPass.setText(response.body().getPass());


                }



            }

            @Override
            public void onFailure(Call<BilgilerPojo> call, Throwable t) {

            }
        });


    }

    public void Update(String userID,String user,String pass){


        Call<BilgiGuncellePojo> request = ManagerAll.getInstance().update(uyeID,user,pass);
        request.enqueue(new Callback<BilgiGuncellePojo>() {
            @Override
            public void onResponse(Call<BilgiGuncellePojo> call, Response<BilgiGuncellePojo> response) {

                if(response.body().isTf())
                {

                    Intent intent = new Intent(BilgilerActivity.this,BilgilerActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Bilgileriniz Güncellenmiştir.",Toast.LENGTH_SHORT).show();
                    finish();


                }


            }

            @Override
            public void onFailure(Call<BilgiGuncellePojo> call, Throwable t) {

            }
        });




    }
}