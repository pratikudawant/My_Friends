package com.example.ganesh.my_friends;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends ActionBarActivity {


    List<MyFriends> array;
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  DBAdapter db = new DBAdapter(this);
       // final ListView lv = (ListView) findViewById(R.id.listView);
      dbHandler = new MyDBHandler(this, null, null, 1);
       // DBAdapter db = new DBAdapter(this);
        ListView lv = (ListView)findViewById(R.id.listView);
        //dbHandler.addStudent("Pratik","Phone","Email");
       // setContentView(R.layout.activity_main);
        //Log.d("New tag","test");
       // setContentView(R.layout.);
        //db.open();
     //   Cursor cursor = db.getAllContacts();
        array = dbHandler.fillstudents();
       // final ListviewFriend clva = new ListviewFriend (MainActivity.this);
       /* if (cursor.moveToFirst())
        {
            do {
                clva.setDataForListView(cursor);
            } while (cursor.moveToNext());
        }
        db.close();
        ListView lv = (ListView)findViewById(R.id.listView);
        */
        ArrayAdapter<MyFriends> a = new ArrayAdapter<MyFriends>(this, android.R.layout.simple_list_item_1,array);
        lv.setAdapter(a);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0,View arg1, int arg2, long arg3)
            {
                Toast.makeText(getApplicationContext(),
                        "Name: " + array.get(arg2).getFriendName() + "\n" +

                        "Email: " + array.get(arg2).getFriendEmail() + "\n" +
                        "Phone:  " + array.get(arg2).getPhone() + "\n"
                        ,Toast.LENGTH_LONG).show();
            }
        });
        dbHandler.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.


        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
