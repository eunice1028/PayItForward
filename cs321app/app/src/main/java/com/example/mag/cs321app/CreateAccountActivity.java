
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
import android.app.*;
import android.graphics.drawable.*;
import android.graphics.*;


public class CreateAccountActivity extends AppCompatActivity{

    private Firebase mRef;
    private Button msubmitBtn;
    private EditText memailField;
    private EditText mpasswordField;
    private EditText mconfirmPasswordField;
    private EditText mfirstnameField;
    private EditText mlastnameField;
    private RadioGroup radioSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        Firebase.setAndroidContext(this);

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        //firebase code: add objects to database
        mRef = new Firebase("https://cs321app.firebaseio.com/Users");
        memailField = (EditText) findViewById(R.id.emailField);
        mpasswordField = (EditText) findViewById(R.id.passwordField);
        mconfirmPasswordField = (EditText) findViewById(R.id.confirmPasswordField);
        mfirstnameField = (EditText) findViewById(R.id.firstnameField);
        mlastnameField = (EditText) findViewById(R.id.lastnameField);
        radioSex = (RadioGroup) findViewById(R.id.radioSex);

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

                if (password.equals(confirmedPassword)) {

                    Firebase mRefChild = mRef.child(email);

                    //Setting each type of information as a new child under the User class
                    Firebase mRefPassword = mRefChild.child("Password");
                    mRefPassword.setValue(password);

                    Firebase mRefFirstname = mRefChild.child("First Name");
                    mRefFirstname.setValue(firstname);

                    Firebase mRefLastname = mRefChild.child("Last Name");
                    mRefLastname.setValue(lastname);

                    Firebase mRefPoints = mRefChild.child("Points");
                    mRefPoints.setValue(10);

                    int selectedID = radioSex.getCheckedRadioButtonId();
                    String gender = ((RadioButton) findViewById(selectedID)).getText().toString();

                    Firebase mRefGender = mRefChild.child("Gender");
                    mRefGender.setValue(gender);

                    Toast.makeText(CreateAccountActivity.this, "Info saved in firebase", Toast.LENGTH_SHORT).show();

                    //start timeline activity
                    startActivity(new Intent(CreateAccountActivity.this, TimelineActivity.class));

                }
                else {
                    Toast.makeText(CreateAccountActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}