package com.example.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
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

    public void exit(View view) {
        finish();
        System.exit(0);
    }

    public void logout(View view) {
        if(getSharedPreferences("UserPrefs",MODE_PRIVATE).getString("email",null)==null)
            Toast.makeText(this, "log in first", Toast.LENGTH_SHORT).show();
        else{
        deleteSharedPreferences("UserPrefs");
        Intent intent=new Intent(this,LogIn.class);
        startActivity(intent);
        finish();
        Toast.makeText(this, "logged out", Toast.LENGTH_SHORT).show();}
    }
}