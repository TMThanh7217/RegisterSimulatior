package com.example.registersimulator;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText edit_username;
    private EditText edit_pwd;
    private EditText edit_re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_username = (EditText)findViewById(R.id.edit_username);
        edit_pwd = (EditText)findViewById(R.id.edit_pwd);
        edit_re = (EditText)findViewById(R.id.edit_re);
    }
}