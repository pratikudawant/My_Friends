package com.example.ganesh.my_friends;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ganesh on 15-02-23.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "friends.db";
    public static final String FRIEND = "friend";
    public static final String FRIEND_ID = "id" ;

    public static final String FRIENDPHONE = "FriendPhone";
    public static final String FRIENDNAME = "FriendName";
    public static final String FRIENDEMAIL = "FriendEmail";

    public static String Create_Friend = "CREATE TABLE "+
            FRIEND+"("+
            FRIEND_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
            FRIENDNAME+" TEXT NOT NULL, "+
            FRIENDPHONE+" TEXT NOT NULL, "+
            FRIENDEMAIL+" TEXT NOT NULL, "+");";
     private Context context;

    public MyDBHandler(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
      this.context = context;
      //  Context context1 = new Context(this);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_Friend);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FRIEND+";");
        onCreate(db);
    }

  /*  public MyFriends findStudent(String friendName ){

        String query = "Select * From " + FRIEND + " WHERE " +
                FRIENDNAME + " = \"" + friendName + "\"" ;


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        MyFriends friend = new MyFriends();
        if(cursor.moveToFirst()){
            cursor.moveToFirst();
            friend.setId(Integer.parseInt(cursor.getString(0)));
            friend.setFriendName(cursor.getString(1));
            friend.setFriendEmail(cursor.getString(2));
            friend.setPhone(cursor.getString(3));
            cursor.close();
        }else{
            friend = null;
        }
        db.close();
        return friend;
    }*/
  public List<MyFriends> fillstudents(){
      List<MyFriends> arrayfriends = new ArrayList<MyFriends>();
     // SQLiteDatabase db = this.getWritableDatabase();

      SQLiteDatabase db = this.getWritableDatabase();
      Cursor cursor = db.rawQuery("SELECT * FROM friend",null);
      if(cursor.moveToFirst()){
          do{
              MyFriends setfriend = new MyFriends();
              setfriend.setFriendName(cursor.getString(1));
              setfriend.setPhone(cursor.getString(2));
              setfriend.setFriendEmail(cursor.getString(3));
              arrayfriends.add(setfriend);
          }while(cursor.moveToNext());
      }return arrayfriends;
  }

  /*  @Override
    public Cursor getAllContacts(){
        return db.query(Create_Friend, new String[] {KEY_ROWID, KEY_NAME,
                KEY_EMAIL}, null, null, null, null, null);
    }*/
}
