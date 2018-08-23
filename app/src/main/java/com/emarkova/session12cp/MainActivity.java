package com.emarkova.session12cp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String AUTHORITY =
            "com.firstexample.emarkova.sesion9.TryProvider";
    private static final String NOTE_TABLE = "NOTES";
    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/" + NOTE_TABLE);

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final int SPACE = 25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        Cursor cursor = getContentResolver().query(CONTENT_URI,null,null, null,null);
        ArrayList<String> names = parseCursor(cursor, "note_name");
        ArrayList<String> dates = parseCursor(cursor,"create_time");
        mAdapter = new MyAdapter(names, dates);
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private ArrayList<String> parseCursor(Cursor cursor, String col) {
        ArrayList<String> result = new ArrayList<String>();
        if(cursor.moveToFirst()) {
            result.add(cursor.getString(cursor.getColumnIndex(col)));
            while (cursor.moveToNext()) {
                result.add(cursor.getString(cursor.getColumnIndex(col)));
            }
        }
        return result;
    }
}
