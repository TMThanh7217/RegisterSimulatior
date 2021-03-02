package com.example.registersimulator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class registerform extends Activity implements View.OnClickListener {

    private Button btn_select;
    private Button btn_signup;
    private Button btn_reset;
    private EditText edit_username;
    private EditText edit_pwd;
    private EditText edit_re;
    private EditText edit_bdate;
    private RadioButton radio_male;
    private RadioButton radio_female;
    private CheckBox check_tennis;
    private CheckBox check_futbal;
    private CheckBox check_others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerform);

        btn_reset = findViewById(R.id.reset_btn);
        btn_reset.setOnClickListener(this);
        btn_signup = findViewById(R.id.signup_btn);
        btn_signup.setOnClickListener(this);

        edit_username = findViewById(R.id.edit_username);
        edit_pwd = findViewById(R.id.edit_pwd);
        edit_re = findViewById(R.id.edit_re);
        edit_bdate = findViewById(R.id.bdate);

        radio_male = findViewById(R.id.radio_male);
        radio_female = findViewById(R.id.radio_female);
        check_tennis = findViewById(R.id.check_tennis);
        check_futbal = findViewById(R.id.check_futbal);
        check_others = findViewById(R.id.check_others);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint("ShowToast")
    @Override
    public void onClick(View v) {
        if(v.getId() == btn_reset.getId()) {
            edit_username.setText(null);
            edit_pwd.setText(null);
            edit_re.setText(null);
            edit_bdate.setText(null);
            radio_male.setChecked(false);
            radio_female.setChecked(false);
            check_futbal.setChecked(false);
            check_others.setChecked(false);
            check_tennis.setChecked(false);
        }
        else if (v.getId() == btn_signup.getId()) {
            if (edit_pwd.getText().toString().equals(edit_re.getText().toString())) {
                Intent signupIntent = new Intent(this, resultform.class);
                Bundle signupBundle = new Bundle();
                signupBundle.putString("username", edit_username.getText().toString());
                signupBundle.putString("pwd", edit_pwd.getText().toString());
                signupBundle.putString("birthdate", edit_bdate.getText().toString());
                signupBundle.putBoolean("gender", radio_male.isChecked());
                signupBundle.putBoolean("tennis", check_tennis.isChecked());
                signupBundle.putBoolean("futbal", check_futbal.isChecked());
                signupBundle.putBoolean("others", check_others.isChecked());
                signupIntent.putExtras(signupBundle);
                startActivityForResult(signupIntent, 1122);
            }
            else
                Toast.makeText(getApplicationContext(),"Retype dose not match password. Please enter again!!!!", Toast.LENGTH_SHORT).show();
        }
    }
}