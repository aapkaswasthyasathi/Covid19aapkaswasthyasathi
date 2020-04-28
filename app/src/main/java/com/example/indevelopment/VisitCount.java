package com.example.indevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class VisitCount extends AppCompatActivity {

    private CheckBox mUpdate, mTest, mYes, mNo;
    private Button toTest;
    String User_details;
    private TextView mDoct, mEscalate, mPrevReport;
    String escalateMsg = "Oh my God!\n\nWe have intimated your nearest Hospital!\nPlease visit without DELAY!\n\nPlease call the number mentioned below for emergencies\n\n 1800 000 XXXX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit_count);

        Intent intent = getIntent();
        User_details = intent.getStringExtra("User_details");

        mUpdate = findViewById(R.id.update_reporte);
        mTest = findViewById(R.id.new_test);
        mYes = findViewById(R.id.yes);
        mNo = findViewById(R.id.no);
        toTest = findViewById(R.id.button);
        mDoct = findViewById(R.id.doctor);
        mEscalate = findViewById(R.id.escalate);
        mPrevReport = findViewById(R.id.prev_rep);

        mUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDoct.setVisibility(View.VISIBLE);
                mYes.setVisibility(View.VISIBLE);
                mNo.setVisibility(View.VISIBLE);
                mUpdate.setEnabled(false);
                mTest.setEnabled(false);
            }
        });
        mTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCovidQues = new Intent(VisitCount.this,CovidQuestions.class);
                toCovidQues.putExtra("User_details",User_details);
                toCovidQues.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                toCovidQues.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(toCovidQues);
                finish();
            }
        });
        mYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPrevReport.setVisibility(View.VISIBLE);
                toTest.setVisibility(View.VISIBLE);
                mYes.setEnabled(false);
                mNo.setEnabled(false);
            }
        });

        mNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEscalate.setVisibility(View.VISIBLE);
                mEscalate.setText(escalateMsg);
                mYes.setEnabled(false);
                mNo.setEnabled(false);
            }
        });
        toTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toCovidQues = new Intent(VisitCount.this,CovidQuestions.class);
                toCovidQues.putExtra("User_details",User_details);
                toCovidQues.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                toCovidQues.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(toCovidQues);
                finish();
            }
        });
    }
}
