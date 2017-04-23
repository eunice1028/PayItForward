package com.example.mag.cs321app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.net.Uri;


import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.UploadTask;

import android.widget.EditText;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class PostActivity extends AppCompatActivity {
    // Pam fields for PostActivity
    private EditText mPostTitle;
    private EditText mPostDescription;
    private EditText mPostTime;
    private ImageButton mSelectImage;
    private static final int GALLERY_REQUEST = 1;

    private Button mSubmitButton;
    private StorageReference mStorage;
    private DatabaseReference mDatabase;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mSelectImage = (ImageButton) findViewById(R.id.imageSelect);
        mSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST);
            }


        });
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
                Uri imageUri = data.getData();
                mSelectImage.setImageURI(imageUri);
            }
        }


//        // Firebase storage root directory
//        mStorage = FirebaseStorage.getInstance().getReference();
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Blog");
//
//        mPostTitle = (EditText) findViewById(R.id.post_title);
//        mPostDescription = (EditText) findViewById(R.id.post_description);
//        mPostDescription = (EditText) findViewById(R.id.post_time);
//        mSubmitButton = (Button) findViewById(R.id.post_button);
//        mProgress= new ProgressDialog(this);
//
//    mSubmitButton.setOnClickListener(new View.OnClickListener(){
//    @Override
//    public void onClick(View view){
//        startPosting();
//    }
//        });
//
//    }
//    private void startPosting(){
//        mProgress.setMessage("Posting to Timeline...");
//        mProgress.show();
//        final String title_val = mPostTitle.getText().toString().trim();
//        final String desc_val = mPostDescription.getText().toString().trim();
//        final String time_val = mPostTime.getText().toString().trim();
//
//    if(!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val)){
//        //StorageReference filepath = mStorage.child("")
//            DatabaseReference newPost = mDatabase.push();
//            newPost.child("title").setValue(title_val);
//            newPost.child("description").setValue(desc_val);
//            newPost.child("time").setValue(time_val);
//
//            mProgress.dismiss();
//
//    }



        // must change read:True write:true on firebase
    }





