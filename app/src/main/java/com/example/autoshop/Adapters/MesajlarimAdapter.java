package com.example.autoshop.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.autoshop.MesajlarimActivity;
import com.example.autoshop.MessageActivity;
import com.example.autoshop.Models.BilgilerPojo;
import com.example.autoshop.OtherId;
import com.example.autoshop.R;
import com.example.autoshop.RestApi.ManagerAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MesajlarimAdapter extends BaseAdapter {

    List<String > otherIdList;
    String userId;
    Context context;
    Activity activity;

    public MesajlarimAdapter(List<String> otherIdList, String userId, Context context,Activity activity) {
        this.otherIdList = otherIdList;
        this.userId = userId;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return otherIdList.size();
    }

    @Override
    public Object getItem(int position) {
        return otherIdList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.otherlayout,parent,false);
        TextView textView;
        textView = convertView.findViewById(R.id.otherText);
        istekAt(otherIdList.get(position).toString(),textView);
        LinearLayout linearLayout = convertView.findViewById(R.id.linearmesaj);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(activity, MessageActivity.class);
                OtherId.setOtherId(otherIdList.get(position));
                activity.startActivity(intent);

            }
        });

        return convertView;
    }
    public void istekAt(String uyeID,final TextView textView){

        Call<BilgilerPojo> request = ManagerAll.getInstance().Bilgiler(uyeID);
        request.enqueue(new Callback<BilgilerPojo>() {
            @Override
            public void onResponse(Call<BilgilerPojo> call, Response<BilgilerPojo> response) {

                if ((response.isSuccessful()))
                {

                 textView.setText(response.body().getUser());



                }



            }

            @Override
            public void onFailure(Call<BilgilerPojo> call, Throwable t) {

            }
        });


    }
}
