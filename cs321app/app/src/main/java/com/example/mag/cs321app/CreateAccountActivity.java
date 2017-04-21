
/*

Created by Shao-Yun Wang
 */


package com.example.mag.cs321app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import com.firebase.client.Firebase;
import android.view.View;
import android.widget.*;


public class CreateAccountActivity extends AppCompatActivity {

    private Firebase mRef;
    private Button msubmitBtn;
    private EditText memailField;
    private EditText mpasswordField;
    private EditText mconfirmPasswordField;
    private EditText mfirstnameField;
    private EditText mlastnameField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Firebase.setAndroidContext(this);

        //firebase code: add objects to database
        mRef = new Firebase("https://cs321app.firebaseio.com/Users");
        memailField = (EditText) findViewById(R.id.emailField);

        msubmitBtn = (Button) findViewById(R.id.submitBtn);

        msubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //all info needed to be stored

            }
        });



    }
}


    // start signing in
    //save info to firebase
   /* String password = mvalueField.getText().toString(); //password (value in tutorial)
    String username = mKeyValue.getText().toString(); //username (key in tutorial)
    Firebase mRefChild = mRef.child(username);

    mRef.setValue(password);*/