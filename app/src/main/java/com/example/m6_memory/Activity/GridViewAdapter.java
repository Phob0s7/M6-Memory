package com.example.m6_memory.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.m6_memory.R;

import java.util.List;

public class GridViewAdapter extends BaseAdapter {

    private Context mContext;

    // Constructor
    public GridViewAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return GameGridActivity.displayCards(GameGridActivity.nombreDeCartes).size();
    }

    @Override
    public Object getItem(int position) {
        return GameGridActivity.displayCards(GameGridActivity.nombreDeCartes).get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(GameGridActivity.displayCards(GameGridActivity.nombreDeCartes).get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
        return imageView;
    }
}



















