package com.example.nicole.musicproject;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer cChord = MediaPlayer.create(this, R.raw.cchord);
        Button playC = this.findViewById(R.id.playCButton);
        playC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                cChord.start();
            }
        });
    }
}







