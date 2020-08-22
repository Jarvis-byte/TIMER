package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class First_Page extends AppCompatActivity {
Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__page);
  timer=new Timer();
  timer.schedule(new TimerTask() {
      @Override
      public void run() {
          Intent intent =new Intent(First_Page.this,MainActivity.class);
          startActivity(intent);
          finish();
      }
  },800);


    }
}