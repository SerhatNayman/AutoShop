package com.example.autoshop.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.autoshop.Models.FavoriSliderPojo;
import com.example.autoshop.Models.SliderPojo;
import com.example.autoshop.R;
import com.example.autoshop.ilanDetay;
import com.example.autoshop.ilanlar;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoriSliderAdapter extends PagerAdapter {

    List<FavoriSliderPojo> SliderList;
    Context context;
    LayoutInflater layoutInflater;
    Activity activity;

    public FavoriSliderAdapter(List<FavoriSliderPojo> sliderList, Context context,Activity activity) {
        SliderList = sliderList;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return SliderList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (RelativeLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.sliderlayout, container, false);

        ImageView imageView = view.findViewById(R.id.sliderImageView);
        Picasso.with(context).load("http://serosoft.tk/autoshop/" + SliderList.get(position).getResimyolu()).resize(1080, 550).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (SliderList.get(position).getIlanid() != null) {
                    Intent intent = new Intent(activity, ilanDetay.class);
                    intent.putExtra("ilanid", SliderList.get(position).getIlanid().toString());
                    activity.startActivity(intent);
                }
            }
        });
        container.addView(view);
        return view;
    }

    public  void destroyItem(ViewGroup container,int position,Object object)
    {

        super.destroyItem(container,position,object);
        container.removeView((View)object);

    }

}
