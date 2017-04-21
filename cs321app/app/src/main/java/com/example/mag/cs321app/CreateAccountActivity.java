
/*

Created by Shao-Yun Wang
 */


package com.example.mag.cs321app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;

public class CreateAccountActivity extends AppCompatActivity{

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
        mpasswordField = (EditText) findViewById(R.id.passwordField);
        mconfirmPasswordField = (EditText) findViewById(R.id.confirmPasswordField);
        mfirstnameField = (EditText) findViewById(R.id.firstnameField);
        mlastnameField = (EditText) findViewById(R.id.lastnameField);

        msubmitBtn = (Button) findViewById(R.id.submitBtn);

        msubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //all info needed to be stored
                String email = memailField.getText().toString();
                String password = mpasswordField.getText().toString();
                String confirmedPassword = mconfirmPasswordField.getText().toString();
                String firstname = mfirstnameField.getText().toString();
                String lastname = mlastnameField.getText().toString();

                Firebase mRefChild = mRef.child(email);

                Firebase mRefPassword = mRefChild.child("Password");
                mRefPassword.setValue(password);

                Firebase mRefFirstname = mRefChild.child("First Name");
                mRefFirstname.setValue(firstname);

                Firebase mRefLastname = mRefChild.child("Last Name");
                mRefLastname.setValue(lastname);

                Toast.makeText(CreateAccountActivity.this,"Info saved in firebase", Toast.LENGTH_LONG).show();
                //start timeline activity
                //startActivity(new Intent(CreateAccountActivity.this, TimelineActivity.class));

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