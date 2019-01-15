package com.example.alvin.simplelogin.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.alvin.simplelogin.dbconstructors.UserConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by User on 1/15/2019.
 */

public class user extends SQLiteOpenHelper {
    public static final String DB_NAME = "db_simplelogin";
    public static final int DB_VERSION = 1;
    user User;


    public user(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserConstructor.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ UserConstructor.TABLE_NAME+"");
        onCreate(db);
    }

    public long insertUser(String...param){
        UserConstructor userConstructor = new UserConstructor();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(userConstructor.FULLNAME,param[0]);
        cv.put(userConstructor.USERNAME,param[1]);
        cv.put(userConstructor.PASSWORD,param[2]);
        cv.put(userConstructor.GENDER,param[3]);
        long result = db.insert(userConstructor.TABLE_NAME,null,cv);
        db.close();
        return result;
    }


    public Cursor SearchUser(String...param){
        UserConstructor userConstructor = new UserConstructor();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+userConstructor.TABLE_NAME+" WHERE "+userConstructor.USERNAME+" = ? AND "+userConstructor.PASSWORD+" = ? LIMIT 1;",new String[]{param[0],param[1]});
        return res;
    }
//
//    public Cursor getAllUser(){
//        UserConstructor userConstructor = new UserConstructor();
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = db.rawQuery("SELECT * FROM "+userConstructor.TABLE_NAME+";",null);
//        return res;
//    }


    public ArrayList<UserConstructor> getAllUser(){
        UserConstructor userConstructor = new UserConstructor();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+userConstructor.TABLE_NAME+";",null);
        ArrayList<UserConstructor> userlist = new ArrayList<UserConstructor>();

        while(cursor.moveToNext()){
            userConstructor = new UserConstructor();
           userConstructor.setIdno(cursor.getInt(cursor.getColumnIndexOrThrow(userConstructor.FIELD_ID)));
            userConstructor.setFullname(cursor.getString(cursor.getColumnIndexOrThrow(userConstructor.FULLNAME)));
            userConstructor.setUsername(cursor.getString(cursor.getColumnIndexOrThrow(userConstructor.USERNAME)));
            userConstructor.setPassword(cursor.getString(cursor.getColumnIndexOrThrow(userConstructor.PASSWORD)));
            userConstructor.setGender(cursor.getString(cursor.getColumnIndexOrThrow(userConstructor.GENDER)));
            userlist.add(userConstructor);
        }
        db.close();
        return  userlist;

    }
}
