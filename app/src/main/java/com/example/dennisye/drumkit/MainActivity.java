package com.example.dennisye.drumkit;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer snare;
    MediaPlayer bass;
    MediaPlayer highhat;
    MediaPlayer symbol;
    ImageButton blue;
    ImageButton green;
    ImageButton red;
    ImageButton yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snare = MediaPlayer.create(this, R.raw.snare);
        bass = MediaPlayer.create(this, R.raw.bass);
        highhat = MediaPlayer.create(this, R.raw.highhat);
        symbol = MediaPlayer.create(this, R.raw.symbol);

        blue = (ImageButton)findViewById(R.id.hihat);
        green = (ImageButton)findViewById(R.id.cymbal);
        red = (ImageButton)findViewById(R.id.snare);
        yellow = (ImageButton)findViewById(R.id.bass);

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(highhat.isPlaying()){
                    highhat.stop();
                    try {
                        highhat.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                highhat.start();
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(symbol.isPlaying()){
                    symbol.stop();
                    try {
                        symbol.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                symbol.start();
            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(snare.isPlaying()){
                    snare.stop();
                    try {
                        snare.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                snare.start();
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bass.isPlaying()){
                    bass.stop();
                    try {
                        bass.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                bass.start();
            }
        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
}
