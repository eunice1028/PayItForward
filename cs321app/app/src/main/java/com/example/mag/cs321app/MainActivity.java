package com.example.mag.cs321app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;



public class MainActivity extends AppCompatActivity {

    private EditText mvalueField;   // Email
    private Button maddBtn;         // login button
    private EditText mKeyValue;     // Username
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

        mvalueField = (EditText) findViewById(R.id.valueField);
        maddBtn = (Button) findViewById(R.id.addBtn);
        mKeyValue = (EditText) findViewById(R.id.keyValue);


        // login button
        maddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // start signing in
                String password = mvalueField.getText().toString(); //password (value in tutorial)
                String username = mKeyValue.getText().toString(); //username (key in tutorial)
                Firebase mRefChild = mRef.child(username);

                mRefChild.setValue(password);

/*
                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){

                    Toast.makeText(MainActivity.this,"Fields are empty", Toast.LENGTH_LONG).show();

                } else {
                    mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Cannot Sign In", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }

*/


            }
        });

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


        msignUpBtn = (Button) findViewById(R.id.signUpBtn);

        msignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateAccountActivity.class));
            }
            //do something when sign up button is clicked

        });

    }


    //@Override
    //protected void onStart(){
      //  super.onStart();

      //  mAuth.addAuthStateListener(mAuthListener);
    //}

}
