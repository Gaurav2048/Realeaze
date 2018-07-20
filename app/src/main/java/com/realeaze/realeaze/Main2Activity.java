package com.realeaze.realeaze;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.edmodo.rangebar.RangeBar;

public class Main2Activity extends AppCompatActivity {
    SeekBar seekbar_train , seekbar_plane, seekbar_bus;
TextView ind_search;
Button result_activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        ind_search = (TextView) findViewById(R.id.ind_search);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Regular.ttf");
        ind_search.setTypeface(typeface);

        seekbar_train = (SeekBar) findViewById(R.id.seekbar_train);
        seekbar_plane = (SeekBar) findViewById(R.id.seekbar_tplane);
        result_activity = (Button) findViewById(R.id.result_activity);
        seekbar_bus = (SeekBar) findViewById(R.id.seekbar_tbuss);

        seekbar_train.getProgressDrawable().setColorFilter(
                Color.argb(255, 46,55,70), PorterDuff.Mode.SRC_IN);
        seekbar_train.getThumb().setColorFilter(Color.argb(255, 46,55,70), PorterDuff.Mode.SRC_IN);

        seekbar_plane.getProgressDrawable().setColorFilter(
                Color.argb(255, 247,93,67), PorterDuff.Mode.SRC_IN);
        seekbar_plane.getThumb().setColorFilter(Color.argb(255, 247,93,67), PorterDuff.Mode.SRC_IN);
        seekbar_bus.getProgressDrawable().setColorFilter(
                Color.argb(255, 247,93,67), PorterDuff.Mode.SRC_IN);
        seekbar_bus.getThumb().setColorFilter(Color.argb(255, 247,93,67), PorterDuff.Mode.SRC_IN);

        result_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ClientRequActivity.class));
            }
        });
    }

}
