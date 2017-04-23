package com.example.mag.cs321app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import android.widget.EditText;
import android.widget.Button;
import android.view.View.OnClickListener;

public class PostActivity extends AppCompatActivity {
    // Pam fields for PostActivity
    private EditText mPostTitle;
    private EditText mPostDescription;

    private Button mSubmitButton;
    private StorageReference mStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        // Firebase storage root directory
        mStorage = FirebaseStorage.getInstance().getReference();

        mPostTitle = (EditText) findViewById(R.id.post_title);
        mPostDescription = (EditText) findViewById(R.id.post_description);
        mSubmitButton = (Button) findViewById(R.id.post_button);

mSubmitButton.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View view){
        startPosting();
    }
        });

    }
    private void startPosting(){
        String title_val = mPostTitle.getText().toString().trim();
        String desc_val = mPostDescription.getText().toString().trim();
    }




}
