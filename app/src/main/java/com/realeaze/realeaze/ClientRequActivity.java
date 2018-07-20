package com.realeaze.realeaze;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.realeaze.realeaze.Adapters.ExtraAdapter;

public class ClientRequActivity extends AppCompatActivity {
RecyclerView extra_recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_clientrec);
        extra_recycler = (RecyclerView) findViewById(R.id.ertra_recycler);
        extra_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        extra_recycler.setAdapter(new ExtraAdapter(getApplicationContext()));
    }
}
