package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.autoshop.Adapters.IlanlarAdapter;
import com.example.autoshop.Models.IlanlarPojo;
import com.example.autoshop.RestApi.ManagerAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ilanlar extends AppCompatActivity {

    ListView listView;
    List<IlanlarPojo> liste;
    IlanlarAdapter ilanlarAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilanlar);
        listView = findViewById(R.id.ilanlarlistview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ilanlar.this, ilanDetay.class);
                intent.putExtra("ilanid", liste.get(position).getIlanid());
                intent.putExtra("uyeid",liste.get(position).getUyeid()+"");
                startActivity(intent);



            }
        });
        ilanlarimiGoruntule();
    }

    public void ilanlarimiGoruntule() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("ILANLAR");
        progressDialog.setMessage("Ilanlar Listeleniyor, Lütfen Bekleyin!");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Call<List<IlanlarPojo>> request = ManagerAll.getInstance().ilanlar();
        request.enqueue(new Callback<List<IlanlarPojo>>() {
            @Override
            public void onResponse(Call<List<IlanlarPojo>> call, Response<List<IlanlarPojo>> response) {

                if (response.isSuccessful()) {

                    if (response.body().get(0).isTf()) {

                        liste = response.body();
                        ilanlarAdapter = new IlanlarAdapter(liste, getApplicationContext());
                        listView.setAdapter(ilanlarAdapter);

                        Toast.makeText(getApplicationContext(), response.body().get(0).getSayi() + "adet ilan listelenmiştir.", Toast.LENGTH_SHORT).show();
                        progressDialog.cancel();


                    }


                }


            }

            @Override
            public void onFailure(Call<List<IlanlarPojo>> call, Throwable t) {

            }
        });
    }
}