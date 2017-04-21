package com.example.mag.cs321app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
public class TimelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get layout from timeline_main
        setContentView(R.layout.timeline_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        // get button pics from main_menu for timeline add button
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == R.id.action_add){

        }

        return super.onOptionsItemSelected(MenuItem item);
    }
}
