package com.example.indevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Questions extends AppCompatActivity {

    private Button button;
    private ProgressBar progressBar;
    String mPrimaryReportText, mSecReport="",User_details;
    private CheckBox mDiabetes,mHypertension,mLungDisease,mBloodSugar,mNota;
    int primaryCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        Intent toreportpage = getIntent();
        mPrimaryReportText = toreportpage.getStringExtra("primary_report");
        User_details = toreportpage.getStringExtra("User_details");
        primaryCounter = toreportpage.getIntExtra("primaryCounter",0);

        mDiabetes = findViewById(R.id.diabetes);
        mHypertension = findViewById(R.id.hypertension);
        mLungDisease = findViewById(R.id.lung_disease);
        mBloodSugar = findViewById(R.id.bloodsugar);
        mNota = findViewById(R.id.nota);
        button = findViewById(R.id.submit);
        progressBar = findViewById(R.id.progressBar);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mNota.isChecked()){
                    if(mDiabetes.isChecked()||mHypertension.isChecked()||mLungDisease.isChecked()||mBloodSugar.isChecked()){
                        Toast.makeText(getApplicationContext(),
                                getString(R.string.Toast_nota),
                                Toast.LENGTH_LONG).show();
                    }
                    else {
                        progressBar.setVisibility(View.VISIBLE);
                        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        final Intent tofinalpage = new Intent(Questions.this,Finalpage.class);
                        Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.INVISIBLE);
                                tofinalpage.putExtra("primaryCounter",primaryCounter);
                                tofinalpage.putExtra("User_details",User_details);
                                tofinalpage.putExtra("primary_report",mPrimaryReportText);
                                tofinalpage.putExtra("Sec_Report",getString(R.string.no_other_complication));
                                tofinalpage.putExtra("Hospital_List",getString(R.string.Hospital_list));
                                startActivity(tofinalpage);
                                tofinalpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                tofinalpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                finish();
                            }
                        }, 5000);
                    }
                }
                else {
                    if(mDiabetes.isChecked()) mSecReport = mSecReport+"-"+ getString(R.string.option_diabetes)+"\n";
                    if(mHypertension.isChecked()) mSecReport = mSecReport+"-"+getString(R.string.option_hypertension)+"\n";
                    if(mLungDisease.isChecked()) mSecReport = mSecReport+"-"+getString(R.string.option_lung_disease)+"\n";
                    if(mBloodSugar.isChecked()) mSecReport = mSecReport+"-"+getString(R.string.option_blood_sugar)+"\n";
                    if(mSecReport=="") Toast.makeText(getApplicationContext(),"-"+getString(R.string.Nothing_selected),Toast.LENGTH_SHORT).show();

                    else{

                        progressBar.setVisibility(View.VISIBLE);
                        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        final Intent tofinalpage = new Intent(Questions.this,Finalpage.class);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.INVISIBLE);
                                tofinalpage.putExtra("primaryCounter",primaryCounter);
                                tofinalpage.putExtra("User_details",User_details);
                                tofinalpage.putExtra("primary_report",mPrimaryReportText);
                                tofinalpage.putExtra("Sec_Report",mSecReport);
                                tofinalpage.putExtra("Hospital_List",getString(R.string.Hospital_list));
                                startActivity(tofinalpage);
                                tofinalpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                tofinalpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                finish();
                            }
                        }, 5000);

                    }
                }
            }
        });
    }
}
