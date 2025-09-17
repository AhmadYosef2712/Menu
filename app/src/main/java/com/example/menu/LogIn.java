package com.example.menu;

import static android.content.Intent.EXTRA_TEXT;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LogIn extends AppCompatActivity {
    private EditText p,u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        BottomNavigationView bt=findViewById(R.id.nav);
        p=findViewById(R.id.p);
        u=findViewById(R.id.u);
        bt.setOnItemSelectedListener(item -> {
            int id=item.getItemId();
            Intent intent=null;
            if (id==R.id.home)
                intent=new Intent(this, MainActivity.class);
            if (id==R.id.dash)
                intent=new Intent(this, Dash.class);
            if (id==R.id.login)
                intent=new Intent(this, LogIn.class);
            startActivity(intent);
            finish();
            return false;
        });


    }

    public void cancel(View view) {
       Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void login(View view) {
        String userName =u.getText().toString();
        String password =p.getText().toString();
        if(userName.isEmpty()|| password.isEmpty() )
            Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show();
        else{
            if(getSharedPreferences("UserPrefs",MODE_PRIVATE).getString("email",null).equals(userName)&&getSharedPreferences("UserPrefs",MODE_PRIVATE).getString("pass",null).equals(password)){
            SharedPreferences share=getSharedPreferences("UserPrefs",MODE_PRIVATE);
            SharedPreferences.Editor editor = share.edit();
            editor.apply();
            Intent intent=new Intent(this, Dash.class);
            startActivity(intent);
            finish();
            Toast.makeText(this, "signed in successfully, welcome admin", Toast.LENGTH_SHORT).show();}
            else
                Toast.makeText(this, "wrong password or userName", Toast.LENGTH_SHORT).show();
        }


    }
}