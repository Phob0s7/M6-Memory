/*
   Class  : MainAdapter
   Author : Sylvain Villoz TINFPT2
   Date   : Novembre 2020
 */

/*
  THIS CLASS IS NOT USED, IT'S JUST TO SHOW THE GRIDVIEW
 */
package com.example.m6_memory.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.m6_memory.R;

/**
 * Class that represents the way to modify the gridView.
 */
public class MainAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int[] hiddenCards;
    private String choiceUser;

    /**
     * Constructor
     */
    public MainAdapter(Context c, int[] hiddenCards, String choiceUser) {
        context = c;
        this.hiddenCards = hiddenCards;
        this.choiceUser = choiceUser;
    }

    /**
     * Display a certain number of cards
     */
    @Override
    public int getCount() {
        int numberCards = 6;

        if (choiceUser == "easy") {
            numberCards = 6;

        } else if (choiceUser == "medium") {
            numberCards = 8;

        } else if (choiceUser == "hard") {
            numberCards = 12;
        }
        return numberCards;
    }

    /**
     * Get a item of the GridView
     */
    @Override
    public Object getItem(int i) {
        return null;
    }

    /**
     * Get a ID item of the GridView
     */
    @Override
    public long getItemId(int i) {
        return 0;
    }

    /**
     * return the gridView
     */
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_item, null);
        }

        ImageView imageView = convertView.findViewById(R.id.activity_row_item_card_imageView);

        imageView.setImageResource(hiddenCards[i]);
        return convertView;
    }
}




