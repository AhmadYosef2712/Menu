package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bt=findViewById(R.id.nav);
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
}


