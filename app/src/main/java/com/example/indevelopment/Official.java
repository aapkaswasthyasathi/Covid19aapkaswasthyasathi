package com.example.indevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Official extends AppCompatActivity {

    private ProgressBar mProgress;
    ImageView mImage1, mImage2, mImage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official);
        mProgress = findViewById(R.id.loading);
        mImage1 = findViewById(R.id.graph_1);
        mImage2 = findViewById(R.id.graph_2);
        mImage3 = findViewById(R.id.graph_3);

        mProgress.setVisibility(View.VISIBLE);
        Toast.makeText(Official.this,"Loading Please Wait...",Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgress.setVisibility(View.INVISIBLE);
                mImage1.setImageResource(R.drawable.graph_bar);
                mImage2.setImageResource(R.drawable.graph_line);
                mImage3.setImageResource(R.drawable.grap_pie);
            }
        }, 5000);

    }
}
