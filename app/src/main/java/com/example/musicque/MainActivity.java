package com.example.musicque;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button button, button1;
    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button =findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        vv= findViewById(R.id.vv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.cho_anh_say);
                mediaPlayer.start();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() +  "/" + R.raw.video));
                vv.start();
                MediaController mediaController = new MediaController(MainActivity.this);
                mediaController.setMediaPlayer(vv);
                vv.setMediaController(mediaController);

            }
        });

    }
}