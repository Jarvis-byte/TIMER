package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SeekBar seekBar;
TextView text;
Button bt;
Boolean counterActive=false;
CountDownTimer countDownTimer;

public void GO()
{       text.setText("0:30");
    seekBar.setProgress(30);
    seekBar.setEnabled(true);
    countDownTimer.cancel();
    bt.setText("GO!");
    counterActive=false;

}
public void onCreate(View view)
{
    if(counterActive)
    {
               GO();
    }
    else
    {


     counterActive=true;
     seekBar.setEnabled(false);
                      bt.setText("STOP!");
   countDownTimer= new CountDownTimer(seekBar.getProgress()*1000+100,1000)
    {

        @Override
        public void onTick(long l) {

               Create((int)l/1000);

        }

        @Override
        public void onFinish() {

            MediaPlayer player=MediaPlayer.create(getApplicationContext(),R.raw.timer);
            player.start();
            GO();
        }
    }.start();}
}
public void Create(int i)
{

    int minutes=i/60;
    int Second=i-(minutes*60);
    String changeSecond=Integer.toString(Second);
    if(Second<=9)
    {
        changeSecond="0"+ changeSecond;

    }
    text.setText(Integer.toString(minutes)+":"+changeSecond);
}



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Toast.makeText(this, "Please Turn on your Sound to full", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar=findViewById(R.id.seekBarTimer);
        text=findViewById(R.id.TextTimer);
        bt=findViewById(R.id.button);
        seekBar.setMax(600);
        seekBar.setProgress(30);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               Create(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}