package com.example.admin.mymusic;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import static android.content.Intent.getIntent;

/**
 * Created by Admin on 08-06-2016.
 */
public class Third extends Service implements MediaPlayer.OnCompletionListener {

    MediaPlayer mp;
    String value="",id;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp=new MediaPlayer();
        Log.e("zzzzzzzz","zzzzzzzzz");
       // Bundle bundle=getIntent().getExtras();

      /*  mp=new MediaPlayer();
        try {
            try1 t=new try1();
            value=t.pass1();
            mp.setDataSource(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.setOnCompletionListener(this);*/
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp.isPlaying())
            mp.stop();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
            if(!mp.isPlaying())
            {
                SharedPreferences sp=getSharedPreferences("gd",0);
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("mytime",mp.getDuration()+"");
                Log.e("iiiiiiiiiiiiii",String.valueOf(mp.getDuration()));
                editor.commit();
                id=(String) intent.getExtras().get("id");
                int x=Integer.parseInt(id);
                if(x==-1)
                {
                    int dur=mp.getDuration();
                    Toast.makeText(this,"Duration "+String.valueOf(dur/60000),Toast.LENGTH_SHORT).show();
                }
                if(x==0)
                {
                    mp.seekTo(5000);
                    mp.start();
                }
                if(x==2){

                    try {
                        value=(String) intent.getExtras().get("value");
                        Log.e("XXXXXXXX",value);
                        mp.setDataSource(value);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mp.setOnCompletionListener(this);
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        public void onPrepared(MediaPlayer mp) {
                            mp.start();
                        }
                    });
                    mp.prepareAsync();
                }
                else if (x==1)
                    mp.start();

            }
        else
            {
                mp.pause();
            }

        return START_STICKY;

    }
    public void updat()
    {
        if(mp.isPlaying())
        {
            Log.e("heheheh","hehehe");
            mp.seekTo(5000);
            Log.e("hahahaha","hahah");
            mp.start();
        }

    }
    public int getDuration() {
        int duration = 0;
        if (mp != null)
            duration = mp.getDuration();
        return duration;
    }
    @Override
    public void onCompletion(MediaPlayer mp) {
        stopSelf();
    }
}
class try1 extends Activity
{
    public String pass1()
    {
        Bundle b=getIntent().getExtras();
      //  Intent i=getIntent();
        String value1="";
        value1=b.getString("value");
        Log.e("ppppppppppp",value1);
        return value1;
    }
}