package com.example.alvin.simplelogin.controllers;


import android.database.Cursor;

import com.example.alvin.simplelogin.dbconstructors.UserConstructor;
import com.example.alvin.simplelogin.helpers.GlobalFunction;
import com.example.alvin.simplelogin.models.user;

import java.util.ArrayList;

/**
 * Created by User on 1/15/2019.
 */

public class UserController {
    private user User;

    public UserController(user UserModel){
        this.User = UserModel;
    }

    public long InsertUser(String...param){
        long res = User.insertUser(param);
        return res;
    }

    public boolean SearchUser(String...param){
       Cursor res = User.SearchUser(param);
        if(res.getCount()==0){
            return false;
        }else{
//            GlobalFunction.Username = res.getString(1).toString();
//            return true;
            while(res.moveToNext()){
                GlobalFunction.Username = res.getString(2).toString();
            }
            return true;
        }
    }


    public ArrayList<UserConstructor> getAllUSER(){
        ArrayList<UserConstructor> userlist = User.getAllUser();
        return userlist;
    }

}
