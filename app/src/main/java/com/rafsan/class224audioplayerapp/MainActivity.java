package com.rafsan.class224audioplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgPlay1,imgPlay2;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPlay1 = findViewById(R.id.imgPlay1);
        imgPlay2 = findViewById(R.id.imgPlay2);

            //  Song 1 ====================================

        imgPlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(imgPlay1.getTag() != null && imgPlay1.getTag().toString().contains("NOT_PLAYING")){

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }

                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.jailer);
                    mediaPlayer.start();
                    imgPlay1.setImageResource(R.drawable.pause_icon);
                    imgPlay1.setTag("PLAYING_NOW");

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {

                            imgPlay1.setImageResource(R.drawable.play_icon);
                            imgPlay1.setTag("NOT_PLAYING");
                        }
                    });

                }
                else {
                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }

                    imgPlay1.setImageResource(R.drawable.play_icon);
                    imgPlay1.setTag("NOT_PLAYING");
                }



            }
        });

        //  Song 2 ====================================
        imgPlay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (imgPlay2.getTag() != null && imgPlay2.getTag().toString().contains("NOT_PLAYING")){

                    if(mediaPlayer != null){
                        mediaPlayer.release();
                    }

                    mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.rolex);
                    mediaPlayer.start();
                    imgPlay2.setImageResource(R.drawable.pause_icon);
                    imgPlay2.setTag("PLAYING_NOW");

                }

                else {
                    if (mediaPlayer != null){
                        mediaPlayer.release();
                    }
                    imgPlay2.setImageResource(R.drawable.play_icon);
                    imgPlay2.setTag("NOT_PLAYING");
                }



            }
        });

    }
}