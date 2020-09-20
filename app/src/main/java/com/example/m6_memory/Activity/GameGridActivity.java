package com.example.m6_memory.Activity;

import android.os.Bundle;
import android.app.Activity;
import android.widget.GridView;

import com.example.m6_memory.Class.BooksAdapter;
import com.example.m6_memory.R;

public class GameGridActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_grid);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new BooksAdapter(this));
    }
}