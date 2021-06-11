package com.example.autoshop;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.autoshop.Models.IlanlarimSilPojo;
import com.example.autoshop.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AlertDialogClass {
    public void IlanlarimAlertDialog(Activity activity, String ilan_id) {


        LayoutInflater inflater = activity.getLayoutInflater();

        View layout = inflater.inflate(R.layout.alertlayout, null);


        Button sil = layout.findViewById(R.id.sil);
        Button geri = layout.findViewById(R.id.silme);

        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setView(layout);
        alert.setCancelable(false);
        final AlertDialog diyalog = alert.create();


        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






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
    public void sil(String ilanid){


        Call<IlanlarimSilPojo> ilanSil = ManagerAll.getInstance().ilanSil(ilanid);
        ilanSil.enqueue(new Callback<IlanlarimSilPojo>() {
            @Override
            public void onResponse(Call<IlanlarimSilPojo> call, Response<IlanlarimSilPojo> response) {



            }

            @Override
            public void onFailure(Call<IlanlarimSilPojo> call, Throwable t) {

            }
        });



    }
}
