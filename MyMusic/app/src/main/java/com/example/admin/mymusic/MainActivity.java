package com.example.admin.mymusic;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {


    String songsL[];
     ArrayAdapter<String> listAdapter ;

    ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SongsManager plm = new SongsManager();
        songsL = plm.getPlayList();
        List<String> planetList = new ArrayList<String>(Arrays.asList(songsL));

        lv=(ListView)findViewById(R.id.listView);
        listAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,planetList);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String mystr=songsL[position];
                Intent i=new Intent(MainActivity.this,Second.class);
                i.putExtra("value",mystr);
                startActivity(i);
            }
        });
    }

    /*@Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String mystr=songsL[position];
        Intent i=new Intent(this,Second.class);
        i.putExtra("value",mystr);
        startActivity(i);
    }*/

    }

