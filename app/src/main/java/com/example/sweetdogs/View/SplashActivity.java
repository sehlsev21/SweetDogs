package com.example.sweetdogs.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.sweetdogs.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private Timer timer;
    private TextView progressCounter;
    private ProgressBar progressBar;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressCounter = findViewById(R.id.progressCounter);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        progressCounter.setText("%0");
        final long period = 950;
        timer = new Timer();



        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(counter<100){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressCounter.setText("%"+ String.valueOf(counter));
                            progressBar.setProgress(counter);
                        }
                    });
                    counter+=20;


                }else{
                    timer.cancel();
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },1000,period);

    }
}