package com.example.admin.mymusic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Second extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener {
    Button b1,b2,b3,b4;
    String value;
    TextView t1;
    int var=1;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mp=new MediaPlayer();
        Intent in=getIntent();
        value=getIntent().getStringExtra("value");


        t1=(TextView)findViewById(R.id.textView);
        t1.setText("Song:"+value);
        value="/Removable/MicroSD/audios/2 states/"+value+".mp3";
        try {
            Log.e("XXXXX",value);
            mp.setDataSource(value);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mp.prepareAsync();
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b1.setOnClickListener(this);
       b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(this,Third.class);
        Button b3=(Button)v;
        String name=b3.getText().toString();

        if(name.equals("play"))
        {
        b1.setText("pause");
          mp.start();

        }
       else if(name.equals("stop"))
        {

            mp.stop();
            finish();

        }
        else if(name.equals("pause"))
        {
            b1.setText("play");
            mp.pause();
        }
        else if(name.equals("get duration"))
        {
              double x=  mp.getDuration()/(60000);
            Toast.makeText(Second.this, String.valueOf(x)+" minutes", Toast.LENGTH_SHORT).show();
        }
        else if(name.equals("fast forward"))
        {
            int x=mp.getCurrentPosition();
            mp.seekTo(x+5000);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.stop();
    }
}
