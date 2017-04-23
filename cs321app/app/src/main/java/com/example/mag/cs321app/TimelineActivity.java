package com.example.mag.cs321app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.Menu;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class TimelineActivity extends AppCompatActivity {

    private RecyclerView mBlogList;

    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get layout from timeline_main
        setContentView(R.layout.timeline_main);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Blog");

        mBlogList = (RecyclerView) findViewById(R.id.blog_list);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        // get button pics from main_menu for timeline add button
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Blog,BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Blog, BlogViewHolder>(
            Blog.class,
            R.layout.blog_row,
            BlogViewHolder.class,
            mDatabase
        ){
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Blog model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDescription());
                viewHolder.setTime(model.getTime());
            }
        };

        mBlogList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public BlogViewHolder(View itemView) {
            super(itemView);

            itemView = mView;
        }
        public void setTitle(String title){
            TextView post_title = (TextView) mView.findViewById(R.id.post_title);
            post_title.setText(title);
        }

        public void setDesc(String desc){

            TextView post_desc = (TextView) mView.findViewById(R.id.post_description);
            post_desc.setText(desc);

        }
        public void setTime(String time){

            TextView post_time = (TextView) mView.findViewById(R.id.post_description);
            post_time.setText(time);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Pam if user clicks add button, move to new post page
        if(item.getItemId() == R.id.action_add){
            startActivity(new Intent(TimelineActivity.this, PostActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
