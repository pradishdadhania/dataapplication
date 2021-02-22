package com.example.dataapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String User_Credentials = "User_Credentials";
    public static final String User_name = "User_name";
    private TextView u_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //use shared preference from other activity
        SharedPreferences settings = getSharedPreferences(User_Credentials, 0);
        String name = settings.getString(User_name, "Hmmmm");
        u_name =(TextView) findViewById(R.id.tvSP);
        u_name.setText(name);



    }
    public void InternalStorageAndroid(View v){
        Intent i =new Intent(MainActivity.this,InternalStorageAndroid.class);
        startActivity(i);
    }

    public void ExternalStorage(View v){
        Intent i =new Intent(MainActivity.this,ExternalStorage.class);
        startActivity(i);
    }
    public void sqllight(View v){
        Intent i =new Intent(MainActivity.this,CountryListActivity.class);
        startActivity(i);
    }
    public void SharedPreferences(View v){
        Intent i =new Intent(MainActivity.this, SharedPreferencesDemo.class);
        startActivity(i);
    }
}