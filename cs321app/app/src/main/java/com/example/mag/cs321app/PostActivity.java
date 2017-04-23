package com.example.mag.cs321app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.net.Uri;


import com.google.android.gms.tasks.OnSuccessListener;
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
    private Uri mImageUri = null;
    private static final int GALLERY_REQUEST = 1;

    private Button mSubmitButton;
    private StorageReference mStorage;
    private DatabaseReference mDatabase;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        mStorage = FirebaseStorage.getInstance().getReference();

        mSelectImage = (ImageButton) findViewById(R.id.imageSelect);
        mPostTitle = (EditText) findViewById(R.id.post_title);
        mPostDescription = (EditText) findViewById(R.id.post_description);
        mPostDescription = (EditText) findViewById(R.id.post_time);
        mSubmitButton = (Button) findViewById(R.id.post_button);
        mProgress = new ProgressDialog(this);

        mSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST);
            }


        });

        mSubmitButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               startPosting();
           }
       });

    }
    private void startPosting(){
        mProgress.setMessage("Posting to Blog...");
        mProgress.show();
        String title_val = mPostTitle.getText().toString().trim();
        String desc_val = mPostDescription.getText().toString().trim();
        String time_val = mPostTime.getText().toString().trim();

        if(!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val) && mImageUri != null){

            StorageReference filepath = mStorage.child("Blog_Images").child(mImageUri.getLastPathSegment());
            filepath.putFile(mImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    mProgress.dismiss();
                }
            });
        }
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
                Uri mImageUri = data.getData();
                mSelectImage.setImageURI(mImageUri);
            }
        }

    }





