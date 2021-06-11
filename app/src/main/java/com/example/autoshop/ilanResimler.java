package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.autoshop.Models.ResimEklePojo;
import com.example.autoshop.RestApi.ManagerAll;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ilanResimler extends AppCompatActivity {

    Button resimsec, resimekle;
    ImageView image;
    Bitmap bitmap;
    String uyeid, ilanid, resim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_resimler);
        tanimla();
        Bundle bundle = getIntent().getExtras();
        uyeid = bundle.getString("uyeid");
        ilanid = bundle.getString("ilanid");

    }

    public void tanimla() {


        resimsec = findViewById(R.id.resimSec);
        resimekle = findViewById(R.id.resimEkle);
        image = findViewById(R.id.secilenResim);

        resimsec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resimGoster();
            }
        });

        resimekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yukle();

            }
        });


    }


    public void resimGoster() {   // 1-) resim galerisini acar

        Intent intent = new Intent();
        intent.setType("image/");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 777);


    }

    public void yukle() { // 4. adım

        resim = imageToString();

        Call<ResimEklePojo> request = ManagerAll.getInstance().resimEkle(uyeid, ilanid, resim);
        request.enqueue(new Callback<ResimEklePojo>() {
            @Override
            public void onResponse(Call<ResimEklePojo> call, Response<ResimEklePojo> response) {

                if (response.body().isTf()) {

                    Toast.makeText(getApplicationContext(), response.body().getSonuc(), Toast.LENGTH_LONG).show();

                    if (response.body().getSonuc().equals("Resim Yuklendi"))
                    {

                       Toast.makeText(getApplicationContext(),"2. Resmi Yükleyiniz",Toast.LENGTH_SHORT).show();

                    }

                } else {

                    Toast.makeText(getApplicationContext(), response.body().getSonuc(), Toast.LENGTH_LONG).show();

                }


            }

            @Override
            public void onFailure(Call<ResimEklePojo> call, Throwable t) {

            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {   //2. adım seçilen resim bitmapa atılır


        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 777 && resultCode == RESULT_OK && data != null) {

            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                image.setImageBitmap(bitmap);
                image.setVisibility(View.VISIBLE);
            } catch (IOException e) {

                e.printStackTrace();


            }


        }


    }

    public String imageToString() {  //3. adım resmi Base64 stringe çeviriyor.


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byt = byteArrayOutputStream.toByteArray();
        String imageToString = Base64.encodeToString(byt, Base64.DEFAULT);
        return imageToString;

    }


}