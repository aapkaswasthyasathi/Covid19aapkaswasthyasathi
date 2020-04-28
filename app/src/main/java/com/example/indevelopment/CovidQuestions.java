package com.example.indevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CovidQuestions extends AppCompatActivity {

    private CheckBox mCough,mFever,mDiff_in_breathing,mTiredness,mAchesOrPains,mNasalCongestion,mSoreThroat,mNota;
    private Button mSubmit_covid_answers;
    String primary_report = "",User_details;
    Integer primaryCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_questions);

        Intent intent = getIntent();
        User_details = intent.getStringExtra("User_details");

        mCough = findViewById(R.id.cough);
        mFever = findViewById(R.id.fever);
        mDiff_in_breathing = findViewById(R.id.diffinbreath);
        mTiredness = findViewById(R.id.tiredness);
        mAchesOrPains = findViewById(R.id.achespains);
        mNasalCongestion = findViewById(R.id.nasal_congestion);
        mSoreThroat = findViewById(R.id.sore_throat);
        mNota = findViewById(R.id.nota);

        mSubmit_covid_answers = findViewById(R.id.submit);

        mSubmit_covid_answers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mNota.isChecked()){
                    if(mCough.isChecked()||mFever.isChecked()||mDiff_in_breathing.isChecked()||mTiredness.isChecked()||
                        mAchesOrPains.isChecked()||mNasalCongestion.isChecked()||mSoreThroat.isChecked()){
                        Toast.makeText(getApplicationContext(),
                                getString(R.string.Toast_nota),
                                Toast.LENGTH_LONG).show();
                    }
                    else {
                        Intent toreportpage = new Intent(CovidQuestions.this,Finalpage.class);
                        toreportpage.putExtra("SafeReport",getString(R.string.Safe_message));
                        toreportpage.putExtra("User_details",User_details);
                        startActivity(toreportpage);
                        toreportpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        toreportpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        finish();
                    }
                }
                else {

                    if(mCough.isChecked())
                    {primaryCounter++; primary_report = primary_report +"-"+ getString(R.string.option_cough)+"\n";}
                    if(mFever.isChecked())
                    {primaryCounter++; primary_report = primary_report + "-"+getString(R.string.option_fever)+"\n";}
                    if(mDiff_in_breathing.isChecked())
                    {primaryCounter++; primary_report = primary_report +"-"+ getString(R.string.option_difficulty_in_breathing)+"\n";}
                    if(mTiredness.isChecked())
                    {primaryCounter++; primary_report = primary_report + "-"+getString(R.string.option_tiredness)+"\n";}
                    if(mAchesOrPains.isChecked())
                    {primaryCounter++; primary_report = primary_report +"-"+ getString(R.string.option_aches_pains)+"\n";}
                    if(mNasalCongestion.isChecked())
                    {primaryCounter++; primary_report = primary_report + "-"+getString(R.string.option_nasal_congestions)+"\n";}

                    if(mSoreThroat.isChecked()) {primaryCounter++; primary_report = primary_report + "-"+getString(R.string.option_sore_throat)+"\n";}

                    if(primary_report=="")Toast.makeText(getApplicationContext(),getString(R.string.Nothing_selected),Toast.LENGTH_SHORT).show();

                    else{
                        Intent toreportpage = new Intent(CovidQuestions.this,Questions.class);
                        toreportpage.putExtra("primaryCounter",primaryCounter);
                        toreportpage.putExtra("primary_report",primary_report);
                        toreportpage.putExtra("User_details",User_details);
                        primary_report="";
                        startActivity(toreportpage);
                        toreportpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        toreportpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        finish();
                    }

                }
            }
        });
    }
}
