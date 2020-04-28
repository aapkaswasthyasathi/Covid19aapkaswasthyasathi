package com.example.indevelopment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class SignIn extends AppCompatActivity {

    Button button;
    ProgressBar progressBar;
    AutoCompleteTextView mGender;
    private CheckBox mOfficialUser;
    TextInputEditText mName,mPhone,mPincode,mAge,mOccupation,mPassword;
    String nameText,phoneText,pinText,ageText,occupationText,genderText,User_details,passwordText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        button=findViewById(R.id.ss_signin);
        progressBar=findViewById(R.id.progressBar4);
        mName = findViewById(R.id.ss_username);
        mGender = findViewById(R.id.ss_sex);
        mPhone = findViewById(R.id.ss_phone_number);
        mPincode = findViewById(R.id.ss_pincode);
        mAge = findViewById(R.id.ss_age);
        mOccupation = findViewById(R.id.ss_occupation);
        mPassword = findViewById(R.id.ss_password);
        mOfficialUser = findViewById(R.id.official_user);


        String[] items = new String[]{
                getString(R.string.gender_male),
                getString(R.string.gender_female),
                getString(R.string.gender_other)};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SignIn.this,R.layout.support_simple_spinner_dropdown_item,items);
        mGender.setAdapter(arrayAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nameText = mName.getText().toString().trim();
                genderText = mGender.getText().toString().trim();
                phoneText = mPhone.getText().toString().trim();
                pinText = mPincode.getText().toString().trim();
                ageText = mAge.getText().toString().trim();
                occupationText = mOccupation.getText().toString().trim();
                passwordText = mPassword.getText().toString().trim();
                if(nameText.isEmpty()||genderText.isEmpty()||phoneText.isEmpty()||pinText.isEmpty()||ageText.isEmpty()||occupationText.isEmpty()||passwordText.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),getString(R.string.empt_field_check),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    progressBar.setVisibility(View.VISIBLE);
                    User_details = getString(R.string.User_details)+":"+ "\n\n"
                            +getString(R.string.hint_name)+" - "+nameText+"\n"
                            +getString(R.string.hint_gender)+" - "+genderText+"\n"
                            +getString(R.string.hint_phone_number)+" - "+phoneText+"\n"
                            +getString(R.string.hint_pincode)+" - "+pinText+"\n"
                            +getString(R.string.hint_age)+" - "+ageText+"\n"
                            +getString(R.string.hint_occupation)+" - "+occupationText+"\n";

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(mOfficialUser.isChecked()){
                                progressBar.setVisibility(View.INVISIBLE);
                                final Intent toOfficials =new Intent(SignIn.this,Official.class);
                                toOfficials.putExtra("User_details",User_details);
                                startActivity(toOfficials);
                                toOfficials.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                toOfficials.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                finish();
                            }
                            else{

                                progressBar.setVisibility(View.INVISIBLE);
                                final Intent toVisitCount =new Intent(SignIn.this,VisitCount.class);
                                toVisitCount.putExtra("User_details",User_details);
                                startActivity(toVisitCount);
                                toVisitCount.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                toVisitCount.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                finish();

                            }

                        }
                    }, 3000);
                }

            }
        });

    }


}
