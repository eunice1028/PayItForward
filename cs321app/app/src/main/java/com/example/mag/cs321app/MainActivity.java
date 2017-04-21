package com.example.mag.cs321app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;



public class MainActivity extends AppCompatActivity {


    private EditText mEmailFied;      // Email
    private Button mlogInBtn;         // login button
    private EditText mPasswordField;  // Password
    private Button msignUpBtn;

    private Firebase mRef;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        //firebase code: add objects to database
        mRef = new Firebase("https://cs321app.firebaseio.com/Users");

        mAuth = FirebaseAuth.getInstance();

<<<<<<< HEAD
        mEmailFied = (EditText) findViewById(R.id.emailField);
        mlogInBtn = (Button) findViewById(R.id.loginBtn);
        mPasswordField = (EditText) findViewById(R.id.passwordField);


        // Set up an AuthStateListener that responds to changes in the user's sign-in state
        mAuthListener = new FirebaseAuth.AuthStateListener() {
=======
        mvalueField = (EditText) findViewById(R.id.valueField);
        maddBtn = (Button) findViewById(R.id.addBtn);
        mKeyValue = (EditText) findViewById(R.id.keyValue);


        // login button
        maddBtn.setOnClickListener(new View.OnClickListener() {
>>>>>>> 35b9e1ef12523b2d07e53d2cf232d985e364ae17
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                // when there is a user active, he will be directed to the account activity page
                if(firebaseAuth.getCurrentUser() == null) {

                    // This line is for testing purpose, can be deleted later
                    Toast.makeText(MainActivity.this, "BYE.", Toast.LENGTH_LONG).show();
                }

<<<<<<< HEAD
                else if(firebaseAuth.getCurrentUser() != null) {

                    Toast.makeText(MainActivity.this, "HELLO.", Toast.LENGTH_LONG).show();

                    // create a new Intent and go to the Home page
                    // ***** AccountActivity page is changed
                    startActivity(new Intent(MainActivity.this, AccountAccivity.class));
=======
                mRefChild.setValue(password);

/*
                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
>>>>>>> 35b9e1ef12523b2d07e53d2cf232d985e364ae17

                    // sign out of the system
                    firebaseAuth.signOut();

                }

<<<<<<< HEAD
            }
        };


=======
*/
>>>>>>> 35b9e1ef12523b2d07e53d2cf232d985e364ae17

        // login button
        mlogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startSignIn();

            }
        });

<<<<<<< HEAD

=======
        // Set up an AuthStateListener that responds to changes in the user's sign-in state
        /*mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                // when there is a user active, he will be directed to the account activity page
                if(firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(MainActivity.this, AccountAccivity.class));
                }
            }
        };*/
>>>>>>> 35b9e1ef12523b2d07e53d2cf232d985e364ae17


        msignUpBtn = (Button) findViewById(R.id.signUpBtn);

        msignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateAccountActivity.class));
            }
            //do something when sign up button is clicked

        });

    }

<<<<<<< HEAD
    @Override
    protected void onStart() {
        super.onStart();
=======

    //@Override
    //protected void onStart(){
      //  super.onStart();
>>>>>>> 35b9e1ef12523b2d07e53d2cf232d985e364ae17

        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startSignIn() {
        String email = mEmailFied.getText().toString();
        String password = mPasswordField.getText().toString();


        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {

            Toast.makeText(MainActivity.this, "Fields are empty.", Toast.LENGTH_LONG).show();

        } else {

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                @Override
                public void onComplete(@NonNull Task<AuthResult> task){
                    if(!task.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Cannot Sign in", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }

}
