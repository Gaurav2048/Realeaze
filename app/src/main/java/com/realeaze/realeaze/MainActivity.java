package com.realeaze.realeaze;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
RelativeLayout signiN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signiN = (RelativeLayout) findViewById(R.id.signiN);
      //   getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F75D43")));
        signiN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, HomeActivity.class));

            }
        });


    }
}
