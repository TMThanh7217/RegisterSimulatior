package com.example.registersimulator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class resultform extends Activity implements View.OnClickListener {

    private TextView viewUsername;
    private TextView viewPwd;
    private TextView viewBirthdate;
    private TextView viewGender;
    private TextView viewHobbies;
    private Button btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultform);

        btn_exit = findViewById(R.id.exit_btn);
        btn_exit.setOnClickListener(this);

        viewUsername = findViewById(R.id.viewUsername);
        viewPwd = findViewById(R.id.viewPwd);
        viewBirthdate = findViewById(R.id.viewBirthDate);
        viewGender = findViewById(R.id.viewGender);
        viewHobbies = findViewById(R.id.viewHobbies);

        Intent signupIntent = getIntent();
        Bundle signupBundle = signupIntent.getExtras();
        String username = signupBundle.getString("username");
        String password = signupBundle.getString("pwd");
        String birthdate = signupBundle.getString("birthdate");
        String gender = signupBundle.getBoolean("gender") ? "Male" : "Female";
        String hobbies = signupBundle.getBoolean("tennis") ? "Tennis " : "";
        hobbies += signupBundle.getBoolean("futbal") ? "FutBal " : "";
        hobbies += signupBundle.getBoolean("others") ? "Other" : "";

        viewUsername.setText(username);
        String encrypt_pwd = "";
        for (int i = 0; i < password.length(); i++)
            encrypt_pwd += "*";
        viewPwd.setText(encrypt_pwd);
        viewBirthdate.setText(birthdate);
        viewGender.setText(gender);
        viewHobbies.setText(hobbies);
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btn_exit.getId()) {
            finish();
            System.exit(0);
        }
    }
}
