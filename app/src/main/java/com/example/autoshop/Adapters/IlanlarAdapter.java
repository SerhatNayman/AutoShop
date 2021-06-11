package com.example.autoshop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.autoshop.Models.IlanlarPojo;
import com.example.autoshop.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class IlanlarAdapter extends BaseAdapter {
    List<IlanlarPojo> ilanlarPojoList;
    Context context;

    public IlanlarAdapter(List<IlanlarPojo> ilanlarPojoList, Context context) {
        this.ilanlarPojoList = ilanlarPojoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return ilanlarPojoList.size();
    }

    @Override
    public Object getItem(int position) {
        return ilanlarPojoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.ilanlarlayout,parent,false);
        TextView baslik,fiyat,adres;
        ImageView resim;

        baslik = convertView.findViewById(R.id.ilanlarBaslik);
        fiyat = convertView.findViewById(R.id.ilanlarFiyat);
        adres = convertView.findViewById(R.id.ilanlarAdres);
        resim = convertView.findViewById(R.id.ilanlarResim);


        baslik.setText(ilanlarPojoList.get(position).getBaslik());
        fiyat.setText(ilanlarPojoList.get(position).getFiyat());
        adres.setText(ilanlarPojoList.get(position).getSehir());
        Picasso.with(context).load("http://serosoft.tk/autoshop/"+ilanlarPojoList.get(position).getResim()).resize(100,100).into(resim);





        return convertView;
    }
}
