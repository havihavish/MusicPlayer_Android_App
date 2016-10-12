package com.example.admin.mymusic;

import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Admin on 08-06-2016.
 */
public class SongsManager {
    final String MEDIA_PATH = new String("/Removable/MicroSD/audios/2 states/");

    public String[] getPlayList()
    {
        File home = new File(MEDIA_PATH);
        String[] songs=new String[6];
        int i;
        if (home.listFiles(new FileExtensionFilter()).length > 0)
        {
             i=0;
            for (File file : home.listFiles(new FileExtensionFilter()))
            {
                if (songs.length == i) {
                    // expand list
                    songs = Arrays.copyOf(songs, songs.length + 1);
                }

                 songs[i]= file.getName().substring(0, (file.getName().length() - 4));
                 i++;
            }
        }
        return songs;
    }
    class FileExtensionFilter implements FilenameFilter {
        public boolean accept(File dir, String name) {
            return (name.endsWith(".mp3") || name.endsWith(".MP3"));
        }
    }
}

