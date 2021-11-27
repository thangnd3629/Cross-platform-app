package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<User> users = initData();
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new ListAdapter(this, users));




    }
    public ArrayList<User> initData(){
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User("thang", "hello", "11:04 AM","09345","Vietnam",R.drawable.navi));
        list.add(new User("thang", "hello", "11:04 AM","09345","Vietnam",R.drawable.navi));
        list.add(new User("thang", "hello", "11:04 AM","09345","Vietnam",R.drawable.navi));
        list.add(new User("thang", "hello", "11:04 AM","09345","Vietnam",R.drawable.navi));
        list.add(new User("thang", "hello", "11:04 AM","09345","Vietnam",R.drawable.navi));
        return  list;
    }
}