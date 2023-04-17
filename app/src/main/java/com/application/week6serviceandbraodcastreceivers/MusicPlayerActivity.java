package com.application.week6serviceandbraodcastreceivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicPlayerActivity extends AppCompatActivity {


    Button play, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);


        play = findViewById(R.id.playButton);
        stop = findViewById(R.id.stopButton);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playIntent = new Intent(MusicPlayerActivity.this, MusicService.class);
                startService(playIntent);
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent playIntent = new Intent(MusicPlayerActivity.this, MusicService.class);
                stopService(playIntent);
            }
        });
    }
}