package com.example.alvin.simplelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alvin.simplelogin.controllers.UserController;
import com.example.alvin.simplelogin.helpers.GlobalFunction;
import com.example.alvin.simplelogin.models.user;

public class LoginForm extends AppCompatActivity {
    Button btnLogin;
    EditText username,pass_word;
    TextView register;
    user User = new user(this);
    UserController userController = new UserController(User);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        btnLogin = (Button)findViewById(R.id.cmdlogin);
        username = (EditText)findViewById(R.id.txtusername);
        pass_word = (EditText)findViewById(R.id.txtpassword);
        register = (TextView)findViewById(R.id.cmdregister);

        register();
        loginuser();

    }

    public void register(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginForm.this,RegisterUser.class);
                startActivity(intent);
            }
        });
    }

    public void loginuser(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname,pass;
                uname = username.getText().toString();
                pass = pass_word.getText().toString();

                if(uname.isEmpty() || pass.isEmpty()){
                    Toast.makeText(LoginForm.this,"PLEASE COMPLETE THE DETAILS",Toast.LENGTH_LONG).show();
                }else{
                   boolean res = userController.SearchUser(uname,pass);
                    if(res){
//                        Toast.makeText(LoginForm.this, GlobalFunction.Username.toString(),Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(LoginForm.this,UserList.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginForm.this, "NOT EXISTED",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
