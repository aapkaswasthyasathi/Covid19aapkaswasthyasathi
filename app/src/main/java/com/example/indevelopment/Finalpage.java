package com.example.indevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Finalpage extends AppCompatActivity {

    private TextView msafe,mPrim,mSec,mhospital,mMyDetails;
    String safeReportText="", primaryReportText, secondaryReportText, hospitalList,User_details,severityText;
    ImageView userImage;
    int primaryCounter, width = 800, height=700, height1=600;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage);
        msafe = findViewById(R.id.SafeReport);
        mPrim = findViewById(R.id.PrimaryReport);
        mSec = findViewById(R.id.SecondaryReport);
        mhospital = findViewById(R.id.HospitalList);
        userImage = findViewById(R.id.userimage);
        mMyDetails = findViewById(R.id.mydetails);

        Intent mRecieveIntent = getIntent();
        if(mRecieveIntent.getStringExtra("SafeReport")!=null)
            safeReportText = mRecieveIntent.getStringExtra("SafeReport");
        else
            safeReportText="";
        primaryCounter = mRecieveIntent.getIntExtra("primaryCounter",0);
        primaryReportText = mRecieveIntent.getStringExtra("primary_report");
        secondaryReportText = mRecieveIntent.getStringExtra("Sec_Report");
        hospitalList = mRecieveIntent.getStringExtra("Hospital_List");
        User_details = mRecieveIntent.getStringExtra("User_details");
        if(primaryCounter<=2)
            severityText = getString(R.string.low_severity);
        else
            severityText = getString(R.string.suspect_corona);



        if(safeReportText!=""){
            msafe.setText(safeReportText);
            mMyDetails.setText(User_details);
            msafe.setTextColor(Color.parseColor("#0C8C40"));
            userImage.setImageResource(R.drawable.healthy);
            mPrim.setBackground(getResources().getDrawable(R.drawable.wash_hands));
            mPrim.getLayoutParams().height=height1;
            mPrim.getLayoutParams().width=width;
            mSec.setBackground(getResources().getDrawable(R.drawable.cover_mouth));
            mPrim.getLayoutParams().height=height;
            mPrim.getLayoutParams().width=width;
            mhospital.setVisibility(View.INVISIBLE);
        }
        else{
            userImage.setImageResource(R.drawable.sick);
            mMyDetails.setText(hospitalList);
            msafe.setText(severityText);
            msafe.setTextColor(Color.parseColor("#FC0D0D"));
            mPrim.setText(String.format("%s%s", getString(R.string.Covid_symptoms), primaryReportText));
            mSec.setText(String.format("%s%s", getString(R.string.non_Covid_symptoms), secondaryReportText));
            mhospital.setText(User_details);
        }
    }
}
