package com.example.alvin.simplelogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.alvin.simplelogin.controllers.UserController;
import com.example.alvin.simplelogin.models.user;

public class RegisterUser extends AppCompatActivity {
    Button btnsave;
    EditText fullname,username,pass_word;
    Spinner gender;
    String[] genderArray = {"MALE","FEMALE"};
    ArrayAdapter genderAddapter;
    user User = new user(this);
    UserController userController = new UserController(User);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        btnsave = (Button)findViewById(R.id.cmdsave);
        fullname = (EditText)findViewById(R.id.txtfullname_R);
        username = (EditText)findViewById(R.id.txtusername_R);
        pass_word  = (EditText)findViewById(R.id.txtpassword_R);
        gender = (Spinner)findViewById(R.id.spngender);

        genderAddapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,genderArray);
        gender.setAdapter(genderAddapter);

        SaveUser();

    }


    public void SaveUser(){
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fullname.getText().toString().isEmpty() || username.getText().toString().isEmpty() || pass_word.getText().toString().isEmpty()){
                    Toast.makeText(RegisterUser.this,"PLEASE COMPLETE THE DETAILS",Toast.LENGTH_LONG).show();
                }else{
                   long res = userController.InsertUser(fullname.getText().toString(),username.getText().toString(),pass_word.getText().toString(),gender.getSelectedItem().toString());
//                    Toast.makeText(RegisterUser.this,Long.toString(res),Toast.LENGTH_LONG).show();
                    if(res==-1){
                        Toast.makeText(RegisterUser.this,"FAILED",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(RegisterUser.this,"SUCCESSFUL",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
