package com.example.alvin.simplelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alvin.simplelogin.controllers.UserController;
import com.example.alvin.simplelogin.dbconstructors.UserConstructor;
import com.example.alvin.simplelogin.models.user;

import java.util.ArrayList;
import java.util.List;

public class UserList extends AppCompatActivity {
    ListView listuser;
    ArrayAdapter useradapter;
    List<String> records = new ArrayList<>();

    user User = new user(this);
    UserController userController = new UserController(User);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        listuser = (ListView)findViewById(R.id.userlistview);


        loadusers();
    }

    public void loadusers(){
        ArrayList<UserConstructor> userlist = userController.getAllUSER();
        records.clear();

        for(int x=0;x<userlist.size();x++){
            records.add(userlist.get(x).getIdno() +"   "+ userlist.get(x).getFullname() + "   " + userlist.get(x).getUsername() + "   " + userlist.get(x).getGender());
        }
        useradapter = new ArrayAdapter(UserList.this,R.layout.sample,records);
        listuser.setAdapter(useradapter);
        useradapter.notifyDataSetChanged();

    }
}
