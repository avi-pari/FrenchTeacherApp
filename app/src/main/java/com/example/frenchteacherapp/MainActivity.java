package com.example.frenchteacherapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private MediaPlayer mediaPlayer1, mediaPlayer2, mediaPlayer3, mediaPlayer4, mediaPlayer5;
    private Button button1, button2, button3, button4, button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        // Set click listeners
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button1) {
            if (mediaPlayer1 == null) {
                mediaPlayer1 = MediaPlayer.create(this, R.raw.black);
            }
            playAudio(mediaPlayer1);
        } else if (id == R.id.button2) {
            if (mediaPlayer2 == null) {
                mediaPlayer2 = MediaPlayer.create(this, R.raw.green);
            }
            playAudio(mediaPlayer2);
        } else if (id == R.id.button3) {
            if (mediaPlayer3 == null) {
                mediaPlayer3 = MediaPlayer.create(this, R.raw.purple);
            }
            playAudio(mediaPlayer3);
        } else if (id == R.id.button4) {
            if (mediaPlayer4 == null) {
                mediaPlayer4 = MediaPlayer.create(this, R.raw.red);
            }
            playAudio(mediaPlayer4);
        } else if (id == R.id.button5) {
            if (mediaPlayer5 == null) {
                mediaPlayer5 = MediaPlayer.create(this, R.raw.yellow);
            }
            playAudio(mediaPlayer5);
        }
    }


    private void playAudio(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    // Release the MediaPlayer when playback is complete
                    mp.release();
                }
            });
        }
    }
}
