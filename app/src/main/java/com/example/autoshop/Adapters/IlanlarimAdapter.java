package com.example.autoshop.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.autoshop.AlertDialogClass;
import com.example.autoshop.Models.IlanlarimPojo;
import com.example.autoshop.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class IlanlarimAdapter extends BaseAdapter {

    List<IlanlarimPojo> list;
    Context context;
    Activity activity;
    String uye_id, ilan_id;


    public IlanlarimAdapter(List<IlanlarimPojo> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View ilanlarimlayout = LayoutInflater.from(context).inflate(R.layout.ilanlarimlayout, parent, false);
        ImageView resim;
        TextView baslik, fiyat;


        resim = ilanlarimlayout.findViewById(R.id.ilanlarimResim);
        baslik = ilanlarimlayout.findViewById(R.id.ilanlarimBaslik);
        fiyat = ilanlarimlayout.findViewById(R.id.ilanlarimFiyat);

        ilan_id = list.get(position).getIlanid();
        uye_id = String.valueOf(list.get(position).getUyeid());
        baslik.setText(list.get(position).getBaslik());
        fiyat.setText(list.get(position).getFiyat());
        Picasso.with(context).load("http://serosoft.tk/autoshop/" + list.get(position).getResim()).resize(100,100).into(resim);


        return ilanlarimlayout;
    }
}
