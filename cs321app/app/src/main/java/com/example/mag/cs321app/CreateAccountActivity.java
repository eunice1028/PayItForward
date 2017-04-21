package com.example.mag.cs321app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }
}
    // start signing in
    //save info to firebase
   /* String password = mvalueField.getText().toString(); //password (value in tutorial)
    String username = mKeyValue.getText().toString(); //username (key in tutorial)
    Firebase mRefChild = mRef.child(username);

    mRef.setValue(password);*/