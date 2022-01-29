package com.example.googlemapactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button,songe,stope,activity3;


   float data= (float) 23.893481296354683;
   float put= (float) 90.40222216887364;

    MediaPlayer mediaPlayer;
    //for volume
    AudioManager audioManager;
    SeekBar volumecontraol;
    ///for volume



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ////convart flat to string
        setContentView(R.layout.activity_main);
        String str=Float.toString(data);
        String datas=String.valueOf(str);
        String p=Float.toString(put);
        String puts=String.valueOf(p);
        stope=findViewById(R.id.stop);
        songe=findViewById(R.id.songe);
        activity3=findViewById(R.id.activity3);
        activity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,User_locations.class);
                startActivity(intent);
            }
        });


        ///for volume
        volumecontraol=findViewById(R.id.volume);
        audioManager=(AudioManager) getSystemService(AUDIO_SERVICE);
        int cureentvolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volumecontraol.setMax(maxVolume);
        volumecontraol.setProgress(cureentvolume);
        volumecontraol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /////for volume





        mediaPlayer=MediaPlayer.create(this,R.raw.sounds);


        stope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              if (mediaPlayer!=null)mediaPlayer.pause();
              else if (mediaPlayer==null)Toast.makeText(getApplicationContext(), "Play frist", Toast.LENGTH_SHORT).show();
            }
        });



        songe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             mediaPlayer.start();
            }
        });





        button=findViewById(R.id.shohid_ahosanulla);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MapsActivity.class);
                intent.putExtra("note",datas);
                intent.putExtra("put",puts);
                startActivity(intent);


            }
        });
    }


}