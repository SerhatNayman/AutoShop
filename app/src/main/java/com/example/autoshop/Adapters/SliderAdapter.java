package com.example.autoshop.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.autoshop.Models.SliderPojo;
import com.example.autoshop.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SliderAdapter extends PagerAdapter {

    List<SliderPojo> SliderList;
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(List<SliderPojo> sliderList, Context context) {
        SliderList = sliderList;
        this.context = context;
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
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.sliderlayout, container, false);

        ImageView imageView = view.findViewById(R.id.sliderImageView);
        Picasso.with(context).load("http://serosoft.tk/autoshop/" + SliderList.get(position).getResim()).resize(1080, 550).into(imageView);

        container.addView(view);
        return view;
    }
}
