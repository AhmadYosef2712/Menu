package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    Intent intent=getIntent();

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.home)
            startActivity(new Intent(this,MainActivity.class));
        if(id==R.id.login)
            startActivity(new Intent(this,LogIn.class));
        if(id==R.id.dash)
            startActivity(new Intent(this,Dash.class));

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_main);


}
    }


