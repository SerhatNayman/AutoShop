package com.example.autoshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.autoshop.Adapters.IlanlarimAdapter;
import com.example.autoshop.Models.IlanlarimPojo;
import com.example.autoshop.Models.IlanlarimSilPojo;
import com.example.autoshop.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ilanlarim extends AppCompatActivity {
    ListView listView;
    IlanlarimAdapter adp;
    List<IlanlarimPojo> liste;
    SharedPreferences preferences;
    String uyeID;
    Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilanlarim);
        preferences = getApplicationContext().getSharedPreferences("giris", 0);
        uyeID = preferences.getString("uyeid", null);
        tanimla();
        ilanlarimiGoruntule();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                IlanlarimAlertDialog(ilanlarim.this, liste.get(position).getIlanid());

            }
        });

    }

    public void tanimla() {


        listView = findViewById(R.id.ilanlarimlist);


    }

    public void ilanlarimiGoruntule() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("ILANLARIM");
        progressDialog.setMessage("Ilanlarınız Yükleniyor Lütfen Bekleyin!");
        progressDialog.setCancelable(false);
        progressDialog.show();


        liste = new ArrayList<>();

        Call<List<IlanlarimPojo>> request = ManagerAll.getInstance().ilanlarim(uyeID);


        request.enqueue(new Callback<List<IlanlarimPojo>>() {
            @Override
            public void onResponse(Call<List<IlanlarimPojo>> call, Response<List<IlanlarimPojo>> response) {

                if (response.isSuccessful()) {


                    liste = response.body();
                    if (response.body().get(0).isTf()) {

                        adp = new IlanlarimAdapter(liste, getApplicationContext(), ilanlarim.this);
                        listView.setAdapter(adp);

                        Toast.makeText(getApplicationContext(), response.body().get(0).getSayi() + " adet İlanınız Bulunmaktadır. ", Toast.LENGTH_SHORT).show();
                        progressDialog.cancel();


                    } else {

                        Intent intent = new Intent(ilanlarim.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Ilanınız Bulunmamaktadır.", Toast.LENGTH_SHORT).show();


                    }

                }


            }

            @Override
            public void onFailure(Call<List<IlanlarimPojo>> call, Throwable t) {

            }
        });

    }


    public void IlanlarimAlertDialog(Activity activity, final String ilan_id) {


        LayoutInflater inflater = activity.getLayoutInflater();

        View layout = inflater.inflate(R.layout.alertlayout, null);


        final Button sil = layout.findViewById(R.id.sil);
        Button geri = layout.findViewById(R.id.silme);

        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setView(layout);
        alert.setCancelable(false);
        final AlertDialog diyalog = alert.create();


        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sil(ilan_id);
                diyalog.cancel();


            }
        });


        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diyalog.cancel();

            }
        });
        diyalog.show();
    }

    public void sil(String ilanid) {


        Call<IlanlarimSilPojo> ilanSil = ManagerAll.getInstance().ilanSil(ilanid);
        ilanSil.enqueue(new Callback<IlanlarimSilPojo>() {
            @Override
            public void onResponse(Call<IlanlarimSilPojo> call, Response<IlanlarimSilPojo> response) {


                if (response.body().isTf()) {

                    ilanlarimiGoruntule();


                }

            }

            @Override
            public void onFailure(Call<IlanlarimSilPojo> call, Throwable t) {

            }
        });


    }


}